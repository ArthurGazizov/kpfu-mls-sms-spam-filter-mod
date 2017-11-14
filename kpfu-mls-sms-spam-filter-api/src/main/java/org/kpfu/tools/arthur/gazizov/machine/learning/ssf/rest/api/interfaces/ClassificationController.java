package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param.Message;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public interface ClassificationController {
  ResponseEntity<ClassificationReport> classify(Long dataSetId, Message sms, String method, Boolean useWeight);
}
