package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.config.KpfuMlsSsfServerConfigurationProperties;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfException;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordTagCounter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service("ssfEngineServiceBayesImpl")
public class SsfEngineServiceBayesImpl implements SsfEngineService {
  @Autowired
  private DictionaryService dictionaryService;

  @Autowired
  private KpfuMlsSsfServerConfigurationProperties config;

  @Override
  public Probability probability(Long dataSetId, String word, Long smsTagId) {
    final TagsStat tagsStat = Optional.of(dataSetId)
            .map(dictionaryService::getTagStat)
            .orElseThrow(KpfuMlsSsfError.STAT_NOT_FOUND::exception);
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

      final Integer wordsCountAssotatedWithTag = Optional.of(smsTagId)
              .map(tagsStat::get)
              .orElseThrow(KpfuMlsSsfError.UNRECOGNIZED_SMS_TAG::exception);

      return Probability.Builder.aProbability()
              .dataSetId(dataSetId)
              .smsTagId(smsTagId)
              .word(word)
              .knownWord(true)
              .value(wordImpressionsCountInTag == 0
                      ? 0
                      : ((1.0 * wordImpressionsCountInTag) / wordsCountAssotatedWithTag))
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
    final TagsStat tagsStat = Optional.of(dataSetId)
            .map(dictionaryService::getTagStat)
            .orElseThrow(KpfuMlsSsfError.STAT_NOT_FOUND::exception);
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

      final Integer wordsCountAssotatedWithTag = Optional.of(smsTagId)
              .map(tagsStat::get)
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
