package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface FileUploadController {
  ResponseEntity<DataSetDto> uploadFile(Long dataSetId, MultipartFile file);
}
