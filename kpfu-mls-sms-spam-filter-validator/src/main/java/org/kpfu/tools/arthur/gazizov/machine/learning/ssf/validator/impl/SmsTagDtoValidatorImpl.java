package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.SmsTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.Valid;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.SmsTagDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.ValidationReport;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.Util.buildReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class SmsTagDtoValidatorImpl implements SmsTagDtoValidator {
  @Override
  public ValidationReport validateToSave(SmsTagDto dto) {
    final List<Valid> errors = Stream.of(idIsNotNull(dto), nameIsEmpty(dto), codeIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToUpdate(SmsTagDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), nameIsEmpty(dto), codeIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToPatch(SmsTagDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), incorrectName(dto), incorrectCode(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  private Valid idIsNotNull(SmsTagDto dto) {
    return new Valid(Objects.nonNull(dto.getId()), "Id is not null");
  }

  private Valid idIsNull(SmsTagDto dto) {
    return new Valid(Objects.isNull(dto.getId()), "Id is null");
  }

  private Valid nameIsEmpty(SmsTagDto dto) {
    return new Valid(StringUtils.isEmpty(dto.getName()), "Name is empty");
  }

  private Valid incorrectName(SmsTagDto dto) {
    final String name = dto.getName();
    return new Valid(Objects.nonNull(name) && !StringUtils.hasText(name), "Incorrect name");
  }

  private Valid codeIsEmpty(SmsTagDto dto) {
    return new Valid(StringUtils.isEmpty(dto.getName()), "Name is empty");
  }

  private Valid incorrectCode(SmsTagDto dto) {
    final String name = dto.getName();
    return new Valid(Objects.nonNull(name) && !StringUtils.hasText(name), "Incorrect name");
  }
}
