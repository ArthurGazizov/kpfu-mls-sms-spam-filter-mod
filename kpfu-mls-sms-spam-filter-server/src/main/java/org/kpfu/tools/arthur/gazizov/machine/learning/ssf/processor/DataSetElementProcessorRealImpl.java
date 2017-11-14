package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.support.Page;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.DataSetElementProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.DataSetElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Service("dataSetElementProcessorRealImpl")
public class DataSetElementProcessorRealImpl extends AbstractCRUDProcessorImpl<DataSetElementDto, DataSetElementModel> implements DataSetElementProcessor {
  @Autowired
  private DataSetElementService dataSetElementService;

  @Autowired
  private DataSetElementConverter dataSetElementConverter;

  @Override
  public CRUDService<DataSetElementModel> crudService() {
    return dataSetElementService;
  }

  @Override
  public Converter<DataSetElementModel, DataSetElementDto> converter() {
    return dataSetElementConverter;
  }

  @Override
  public ResponseEntity<PageResponse<DataSetElementDto>> page(Long dataSetId, Integer offset, Integer limit) {
    final Page<DataSetElementModel> page = dataSetElementService.page(dataSetId, offset, limit);
    PageResponse<DataSetElementDto> pageResponse = new PageResponse<>();
    pageResponse.setOffset(page.getOffset());
    pageResponse.setTotalCount(page.getTotalCount());
    pageResponse.setData(page.getData().stream().map(converter()::convert).collect(Collectors.toList()));
    return ResponseEntity.ok(pageResponse);
  }
}
