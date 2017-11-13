package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.SmsTagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.SmsTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.SmsTagProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.SmsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service("smsTagProcessorRealImpl")
public class SmsTagProcessorRealImpl extends AbstractCRUDProcessorImpl<SmsTagDto, SmsTagModel> implements SmsTagProcessor {
  @Autowired
  private SmsTagService smsTagService;

  @Autowired
  private SmsTagConverter smsTagConverter;

  @Override
  public CRUDService<SmsTagModel> crudService() {
    return smsTagService;
  }

  @Override
  public Converter<SmsTagModel, SmsTagDto> converter() {
    return smsTagConverter;
  }
}
