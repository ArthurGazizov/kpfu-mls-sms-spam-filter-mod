package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param.ClassificationMethod;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public interface ClassificationProcessor {
  ResponseEntity<ClassificationReport> classify(Long dataSetId, String sms, ClassificationMethod method, Boolean useWeight);
}
