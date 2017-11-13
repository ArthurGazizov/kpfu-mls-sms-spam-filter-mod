package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.SmsTagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.SmsTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Component
@Conversion(model = SmsTagModel.class, dto = SmsTagDto.class)
public class SmsTagConverterImpl implements SmsTagConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public SmsTagDto convert(SmsTagModel model) {
    return SmsTagDto.Builder.aSmsTagDto()
            .id(model.getId())
            .name(model.getName())
            .code(model.getCode())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }

  @Override
  public SmsTagModel convert(SmsTagDto dto) {
    return SmsTagModel.Builder.aSmsTagModel()
            .id(dto.getId())
            .name(dto.getName())
            .code(dto.getCode())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .build();
  }
}
