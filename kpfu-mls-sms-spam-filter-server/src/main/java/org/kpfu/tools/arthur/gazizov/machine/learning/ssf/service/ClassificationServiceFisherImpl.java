package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassValue;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
@Service("classificationServiceFisherImpl")
public class ClassificationServiceFisherImpl implements ClassificationService {
  @Override
  public ClassificationReport classify(Long dataSetId, String sms, Boolean useWeight) {
    System.err.println("=");
    System.err.println(sms);
    System.err.println("=");
    return ClassificationReport.Builder.aClassificationReport()
            .classValues(Collections.singletonList(ClassValue.Builder.aClassValue()
                    .smsTagId(1L)
                    .probability(56.6)
                    .build()))
            .build();
  }
}
