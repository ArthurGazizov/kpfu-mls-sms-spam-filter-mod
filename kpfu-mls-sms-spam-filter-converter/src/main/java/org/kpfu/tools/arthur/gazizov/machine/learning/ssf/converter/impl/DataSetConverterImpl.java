package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Component
@Conversion(model = DataSetModel.class, dto = DataSetDto.class)
public class DataSetConverterImpl implements DataSetConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public DataSetDto convert(DataSetModel model) {
    return DataSetDto.Builder.aDataSetDto()
            .id(model.getId())
            .name(model.getName())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }

  @Override
  public DataSetModel convert(DataSetDto dto) {
    return DataSetModel.Builder.aDataSetModel()
            .id(dto.getId())
            .name(dto.getName())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .build();
  }
}
