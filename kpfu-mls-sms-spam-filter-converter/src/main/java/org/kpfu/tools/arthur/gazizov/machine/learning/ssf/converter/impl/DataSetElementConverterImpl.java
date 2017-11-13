package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
@Component
@Conversion(model = DataSetElementModel.class, dto = DataSetElementDto.class)
public class DataSetElementConverterImpl implements DataSetElementConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public DataSetElementDto convert(DataSetElementModel model) {
    return DataSetElementDto.Builder.aDataSetElementDto()
            .id(model.getId())
            .smsTagId(model.getSmsTagId())
            .sms(model.getSms())
            .datasetId(model.getDatasetId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }

  @Override
  public DataSetElementModel convert(DataSetElementDto dto) {
    return DataSetElementModel.Builder.aDataSetElementModel()
            .id(dto.getId())
            .smsTagId(dto.getSmsTagId())
            .sms(dto.getSms())
            .datasetId(dto.getDatasetId())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .build();
  }
}
