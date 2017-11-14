package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param.ClassificationMethod;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.ClassificationProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
@Service
public class ClassificationProcessorImpl implements ClassificationProcessor {
  @Autowired
  @Qualifier("classificationServiceFisherImpl")
  private ClassificationService classificationServiceFisherImpl;

  @Autowired
  @Qualifier("classificationServiceBayesImpl")
  private ClassificationService classificationServiceBayesImpl;

  @Override
  public ResponseEntity<ClassificationReport> classify(Long dataSetId, String sms, ClassificationMethod method, Boolean useWeight) {
    final ClassificationReport classificationReport = choose(method).classify(dataSetId, sms, useWeight);
    return ResponseEntity.ok(classificationReport);
  }

  private ClassificationService choose(ClassificationMethod method) {
    return ClassificationMethod.BAYES_CLASSIFICATION.equals(method)
            ? classificationServiceBayesImpl
            : classificationServiceFisherImpl;
  }
}
