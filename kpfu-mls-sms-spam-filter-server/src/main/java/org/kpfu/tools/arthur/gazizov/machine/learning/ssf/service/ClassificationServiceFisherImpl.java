package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassValue;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.SmsAnalyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
@Service("classificationServiceFisherImpl")
public class ClassificationServiceFisherImpl implements ClassificationService {
  @Autowired
  private SmsAnalyser smsAnalyser;

  @Autowired
  private SmsTagService smsTagService;

  @Autowired
  @Qualifier("ssfEngineServiceFisherImpl")
  private SsfEngineService ssfEngineService;

  @Override
  public ClassificationReport classify(Long dataSetId, String sms, Boolean useWeight) {
    final List<SmsTagModel> smsTags = smsTagService.findAll();
    final List<String> words = smsAnalyser.fetchWords(sms);
    final List<ClassValue> classValueList = smsTags.stream()
            .map(SmsTagModel::getId)
            .map(smsTagId -> {
              Double p = 1.0;
              for (String word : words) {
                final Probability probability = probability(dataSetId, word, smsTagId, useWeight);
                if (probability.getKnownWord()) {
                  p *= probability.getValue();
                }
              }
              final double value = Math.abs(p) < 1e-30 ? 0.0 : chiSqr(-2 * Math.log(p), words.size() * 2);
              return ClassValue.Builder.aClassValue()
                      .probability(value)
                      .smsTagId(smsTagId)
                      .build();
            })
            .collect(Collectors.toList());
    classValueList.sort(Comparator.comparing(ClassValue::getProbability).reversed());
    return ClassificationReport.Builder.aClassificationReport()
            .classValues(classValueList)
            .build();
  }

  private Probability probability(Long dataSetId, String word, Long smsTagId, Boolean useWeight) {
    return useWeight
            ? ssfEngineService.probability(dataSetId, word, smsTagId)
            : ssfEngineService.weightProbability(dataSetId, word, smsTagId);
  }

  private double chiSqr(double chi, int df) {
    double m = chi / 2;
    double term = Math.exp(-m);
    double sum = term;
    int end = df / 2;
    for (int i = 1; i <= end; i++) {
      term *= m / i;
      sum += term;
    }
    return Math.min(sum, 1.0);
  }
}
