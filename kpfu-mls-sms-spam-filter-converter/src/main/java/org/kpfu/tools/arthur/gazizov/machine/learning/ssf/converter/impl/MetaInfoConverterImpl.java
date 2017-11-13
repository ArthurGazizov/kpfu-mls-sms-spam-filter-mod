package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.MetaInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.MetaInfoModel;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Component
@Conversion(model = MetaInfoModel.class, dto = MetaInfoDto.class)
public class MetaInfoConverterImpl implements MetaInfoConverter {
  @Override
  public MetaInfoDto convert(MetaInfoModel model) {
    return MetaInfoDto.Builder.aMetaInfoDto()
            .createdTs(model.getCreatedTs())
            .updatedTs(model.getUpdatedTs())
            .build();
  }

  @Override
  public MetaInfoModel convert(MetaInfoDto dto) {
    return MetaInfoModel.Builder.aMetaInfoEntity()
            .build();
  }
}
