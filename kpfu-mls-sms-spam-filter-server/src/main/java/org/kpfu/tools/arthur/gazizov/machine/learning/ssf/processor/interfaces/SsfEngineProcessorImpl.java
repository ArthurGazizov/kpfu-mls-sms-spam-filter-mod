package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.SsfEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class SsfEngineProcessorImpl implements SsfEngineProcessor {
  @Autowired
  private SsfEngineService ssfEngineService;

  @Override
  public ResponseEntity<Probability> calculateProbability(Long dataSetId, String word, Long smsTagId) {
    validate(dataSetId, word, smsTagId);
    word = word.trim().toLowerCase();
    final Probability probability = ssfEngineService.probability(dataSetId, word, smsTagId);
    return ResponseEntity.ok(probability);
  }

  @Override
  public ResponseEntity<Probability> calculateWeightProbability(Long dataSetId, String word, Long smsTagId) {
    validate(dataSetId, word, smsTagId);
    word = word.trim().toLowerCase();
    final Probability probability = ssfEngineService.weightProbability(dataSetId, word, smsTagId);
    return ResponseEntity.ok(probability);
  }


  private void validate(Long dataSetId, String word, Long smsTagId) {
    Objects.requireNonNull(dataSetId);
    Objects.requireNonNull(word);
    Objects.requireNonNull(smsTagId);
    word = word.trim().toLowerCase();
    if (StringUtils.isEmpty(word)) {
      throw KpfuMlsSsfError.UNRECOGNIZED_WORD.exception();
    }
  }
}
