package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.config.KpfuMlsSsfServerConfigurationProperties;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfException;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordTagCounter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
@Service("ssfEngineServiceFisherImpl")
public class SsfEngineServiceFisherImpl implements SsfEngineService {
  @Autowired
  private DictionaryService dictionaryService;

  @Autowired
  private KpfuMlsSsfServerConfigurationProperties config;

  @Override
  public Probability probability(Long dataSetId, String word, Long smsTagId) {
    final WordsStat wordsStat = Optional.of(dataSetId)
            .map(dictionaryService::getWordStat)
            .orElseThrow(KpfuMlsSsfError.STAT_NOT_FOUND::exception);

    try {
      final WordTagCounter wordTagCounter = Optional.of(word)
              .map(wordsStat::get)
              .orElseThrow(KpfuMlsSsfError.UNRECOGNIZED_WORD::exception);

      final Integer wordImpressionsCountInTag = Optional.of(smsTagId)
              .map(wordTagCounter::get)
              .orElseThrow(KpfuMlsSsfError.UNRECOGNIZED_SMS_TAG::exception);

      final int total = wordTagCounter.values().stream().mapToInt(i -> i).sum();

      return Probability.Builder.aProbability()
              .dataSetId(dataSetId)
              .smsTagId(smsTagId)
              .word(word)
              .knownWord(true)
              .value(total == 0
                      ? 0
                      : ((1.0 * wordImpressionsCountInTag) / total))
              .build();
    } catch (KpfuMlsSsfException ex) {
      return Probability.Builder.aProbability()
              .dataSetId(dataSetId)
              .smsTagId(smsTagId)
              .word(word)
              .knownWord(false)
              .value(1.0)
              .build();
    }
  }

  @Override
  public Probability weightProbability(Long dataSetId, String word, Long smsTagId) {
    final WordsStat wordsStat = Optional.of(dataSetId)
            .map(dictionaryService::getWordStat)
            .orElseThrow(KpfuMlsSsfError.STAT_NOT_FOUND::exception);

    try {
      final WordTagCounter wordTagCounter = Optional.of(word)
              .map(wordsStat::get)
              .orElseThrow(KpfuMlsSsfError.UNRECOGNIZED_WORD::exception);

      final Integer wordImpressionsCountInTag = Optional.of(smsTagId)
              .map(wordTagCounter::get)
              .orElseThrow(KpfuMlsSsfError.UNRECOGNIZED_SMS_TAG::exception);

      final Double weight = config.getWeight();
      final Double aprioriProbability = config.getAprioriProbability();

      final Probability probability = probability(dataSetId, word, smsTagId);

      Double numerator = weight * aprioriProbability + wordImpressionsCountInTag * probability.getValue();
      Double denominator = wordImpressionsCountInTag + weight;

      return Probability.Builder.aProbability()
              .dataSetId(dataSetId)
              .smsTagId(smsTagId)
              .word(word)
              .knownWord(true)
              .value(denominator == 0.0
                      ? 0
                      : (numerator / denominator))
              .build();
    } catch (KpfuMlsSsfException ex) {
      return Probability.Builder.aProbability()
              .dataSetId(dataSetId)
              .smsTagId(smsTagId)
              .word(word)
              .knownWord(false)
              .value(1.0)
              .build();
    }
  }
}
