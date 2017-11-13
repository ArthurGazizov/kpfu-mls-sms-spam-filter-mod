package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.Util;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.Valid;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.DataSetElementDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.ValidationReport;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class DataSetElementDtoValidatorImpl implements DataSetElementDtoValidator {
  @Override
  public ValidationReport validateToSave(DataSetElementDto dto) {
    final List<Valid> errors = Stream.of(idIsNotNull(dto), smsTagIsNull(dto), datasetIdIsNull(dto), smsIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return Util.buildReport(errors);
  }

  @Override
  public ValidationReport validateToUpdate(DataSetElementDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), smsTagIsNull(dto), datasetIdIsNull(dto), smsIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return Util.buildReport(errors);
  }

  @Override
  public ValidationReport validateToPatch(DataSetElementDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), incorrectSms(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return Util.buildReport(errors);
  }

  private Valid idIsNotNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.nonNull(dataSetElementDto.getId()), "Id is not null");
  }

  private Valid idIsNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.isNull(dataSetElementDto.getId()), "Id is null");
  }

  private Valid datasetIdIsNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.isNull(dataSetElementDto.getDatasetId()), "Dataset id is null");
  }

  private Valid smsTagIsNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.isNull(dataSetElementDto.getSmsTagId()), "Sms tag is null");
  }

  private Valid incorrectSms(DataSetElementDto dataSetElementDto) {
    final String sms = dataSetElementDto.getSms();
    return new Valid(Objects.nonNull(sms) && !StringUtils.hasText(sms), "Incorrect sms");
  }

  private Valid smsIsEmpty(DataSetElementDto dataSetElementDto) {
    final String sms = dataSetElementDto.getSms();
    return new Valid(StringUtils.isEmpty(sms), "Sms is empty");
  }
}
