package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.ValidationReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface ValidationReportChecker {
  void check(ValidationReport validationReport);
}
