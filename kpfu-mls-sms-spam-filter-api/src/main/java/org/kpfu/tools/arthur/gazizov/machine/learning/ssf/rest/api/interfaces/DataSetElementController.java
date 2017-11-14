package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.base.CRUDController;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
public interface DataSetElementController extends CRUDController<DataSetElementDto> {
  ResponseEntity<PageResponse<DataSetElementDto>> page(Long dataSetId, Integer offset, Integer limit);
}
