package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public interface ClassificationService {
  ClassificationReport classify(Long dataSetId, String sms, Boolean useWeight);
}
