package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface SsfEngineController {
  ResponseEntity<Probability> calculateProbability(Long dataSetId, String word, Long smsTagId);

  ResponseEntity<Probability> calculateWeightProbability(Long dataSetId, String word, Long smsTagId);
}
