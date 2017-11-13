package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.base.FailValidationReportImpl;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Component
public class ValidationReportCheckerImpl implements ValidationReportChecker {
  @Override
  public void check(ValidationReport validationReport) {
    if (validationReport instanceof FailValidationReportImpl) {
      final FailValidationReportImpl failValidationReport = (FailValidationReportImpl) validationReport;
      throw KpfuMlsSsfError.VALIDATION_ERROR.exception(failValidationReport.getMessage());
    }
  }
}
