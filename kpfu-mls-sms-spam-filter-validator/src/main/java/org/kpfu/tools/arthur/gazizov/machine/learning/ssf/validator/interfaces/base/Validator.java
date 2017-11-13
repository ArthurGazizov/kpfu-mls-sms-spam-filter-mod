package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.ValidationReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public interface Validator<T extends Dto> {
  ValidationReport validateToSave(T dto);

  ValidationReport validateToUpdate(T dto);

  ValidationReport validateToPatch(T dto);
}

