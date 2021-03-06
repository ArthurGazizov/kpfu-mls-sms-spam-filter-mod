package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface SsfEngineService {
  Probability probability(Long dataSetId, String word, Long smsTagId);

  Probability weightProbability(Long dataSetId, String word, Long smsTagId);
}
