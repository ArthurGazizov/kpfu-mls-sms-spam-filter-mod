package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.SmsTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.SmsTagProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
@Primary
public class SmsTagProcessorImpl implements SmsTagProcessor {
  @Autowired
  @Qualifier("smsTagProcessorProxyImpl")
  private SmsTagProcessor smsTagProcessor;

  @Override
  public ResponseEntity<SmsTagDto> get(Long id) {
    return smsTagProcessor.get(id);
  }

  @Override
  public ResponseEntity<SmsTagDto> save(SmsTagDto smsTagDto) {
    return smsTagProcessor.save(smsTagDto);
  }

  @Override
  public ResponseEntity<SmsTagDto> update(SmsTagDto smsTagDto) {
    return smsTagProcessor.update(smsTagDto);

  }

  @Override
  public ResponseEntity<SmsTagDto> patch(SmsTagDto smsTagDto) {
    return smsTagProcessor.patch(smsTagDto);

  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    return smsTagProcessor.delete(id);

  }

  @Override
  public ResponseEntity<SmsTagDto> restore(Long id) {
    return smsTagProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<SmsTagDto>> findAll() {
    return smsTagProcessor.findAll();

  }
}
