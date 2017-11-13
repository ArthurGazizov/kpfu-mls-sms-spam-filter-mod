package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.SmsTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.SmsTagProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.SmsTagDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.report.ValidationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service("smsTagProcessorProxyImpl")
public class SmsTagProcessorProxyImpl implements SmsTagProcessor {
  @Autowired
  private SmsTagDtoValidator smsTagDtoValidator;

  @Autowired
  private ValidationReportChecker validationReportChecker;

  @Autowired
  @Qualifier("smsTagProcessorRealImpl")
  private SmsTagProcessor smsTagProcessor;

  @Override
  public ResponseEntity<SmsTagDto> get(Long id) {
    Objects.requireNonNull(id);
    return smsTagProcessor.get(id);
  }

  @Override
  public ResponseEntity<SmsTagDto> save(SmsTagDto smsTagDto) {
    final ValidationReport validationReport = smsTagDtoValidator.validateToSave(smsTagDto);
    validationReportChecker.check(validationReport);
    return smsTagProcessor.save(smsTagDto);
  }

  @Override
  public ResponseEntity<SmsTagDto> update(SmsTagDto smsTagDto) {
    final ValidationReport validationReport = smsTagDtoValidator.validateToUpdate(smsTagDto);
    validationReportChecker.check(validationReport);
    return smsTagProcessor.update(smsTagDto);
  }

  @Override
  public ResponseEntity<SmsTagDto> patch(SmsTagDto smsTagDto) {
    final ValidationReport validationReport = smsTagDtoValidator.validateToPatch(smsTagDto);
    validationReportChecker.check(validationReport);
    return smsTagProcessor.patch(smsTagDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    Objects.requireNonNull(id);
    return smsTagProcessor.delete(id);
  }

  @Override
  public ResponseEntity<SmsTagDto> restore(Long id) {
    Objects.requireNonNull(id);
    return smsTagProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<SmsTagDto>> findAll() {
    return smsTagProcessor.findAll();
  }
}
