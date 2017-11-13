package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.FileUploaderProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces.FileUploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Controller
@RequestMapping(value = "/v1/ssf/upload", produces = {APPLICATION_JSON_VALUE})
@Api(value = "FileUploadController", description = "The FileUploadController API")
public class FileUploadControllerImpl implements FileUploadController {
  @Autowired
  private FileUploaderProcessor fileUploaderProcessor;

  @ApiOperation(value = "Upload file", notes = "", response = DataSetDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = DataSetDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset/{id}",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<DataSetDto> uploadFile(@ApiParam(value = "id", required = true)
                                               @PathVariable("id") Long dataSetId,
                                               @ApiParam(value = "file detail") @RequestPart(value = "file", required = true) MultipartFile file) {
    return fileUploaderProcessor.uploadFile(dataSetId, file);
  }
}
