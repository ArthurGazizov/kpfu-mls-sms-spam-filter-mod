package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.FileUploaderProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.FileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class FileUploaderProcessorImpl implements FileUploaderProcessor {
  @Autowired
  private FileUploaderService service;

  @Autowired
  private DataSetConverter dataSetConverter;

  @Override
  public ResponseEntity<DataSetDto> uploadFile(Long dataSetId, MultipartFile multipartFile) {
    final DataSetModel dataSetModel = service.uploadFile(dataSetId, multipartFile);
    final DataSetDto dto = dataSetConverter.convert(dataSetModel);
    return ResponseEntity.ok(dto);
  }
}
