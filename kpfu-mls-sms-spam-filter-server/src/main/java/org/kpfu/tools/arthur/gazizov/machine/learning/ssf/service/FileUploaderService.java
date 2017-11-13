package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetModel;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface FileUploaderService {
  DataSetModel uploadFile(Long datasetId, MultipartFile file);
}
