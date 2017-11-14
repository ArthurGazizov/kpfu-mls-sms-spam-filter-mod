package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.base.CRUDProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.DataSetElementProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces.DataSetElementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Controller
@RequestMapping(value = "/v1/ssf/dataset/", produces = {APPLICATION_JSON_VALUE})
@Api(value = "DataSetElementController", description = "The DataSetElementController API")
public class DataSetElementControllerImpl implements DataSetElementController {
  @Autowired
  private DataSetElementProcessor dataSetElementProcessor;

  @ApiOperation(value = "Get Dataset element", notes = "", response = DataSetElementDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = DataSetElementDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<DataSetElementDto> get(@ApiParam(value = "id", required = true)
                                               @PathVariable("id") Long id) {
    return DataSetElementController.super.get(id);
  }

  @ApiOperation(value = "Save Dataset element", notes = "", response = DataSetElementDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = DataSetElementDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<DataSetElementDto> save(@ApiParam(value = "dataSetElementDto", required = true)
                                                @RequestBody DataSetElementDto dataSetElementDto) {
    return DataSetElementController.super.save(dataSetElementDto);
  }

  @ApiOperation(value = "Update Dataset element", notes = "", response = DataSetElementDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = DataSetElementDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element",
          produces = {"application/json"},
          method = RequestMethod.PUT)
  @Override
  public ResponseEntity<DataSetElementDto> update(@ApiParam(value = "dataSetElementDto", required = true)
                                                  @RequestBody DataSetElementDto dataSetElementDto) {
    return DataSetElementController.super.update(dataSetElementDto);
  }

  @ApiOperation(value = "Patch Dataset element", notes = "", response = DataSetElementDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = DataSetElementDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element",
          produces = {"application/json"},
          method = RequestMethod.PATCH)
  @Override
  public ResponseEntity<DataSetElementDto> patch(@ApiParam(value = "dataSetElementDto", required = true)
                                                 @RequestBody DataSetElementDto dataSetElementDto) {
    return DataSetElementController.super.patch(dataSetElementDto);
  }

  @ApiOperation(value = "Delete Dataset element", notes = "")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element/{id}",
          produces = {"application/json"},
          method = RequestMethod.DELETE)
  @Override
  public ResponseEntity<Void> delete(@ApiParam(value = "id", required = true)
                                     @PathVariable("id") Long id) {
    return DataSetElementController.super.delete(id);
  }

  @ApiOperation(value = "Get all Datasets elements", notes = "", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = List.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element/all",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<List<DataSetElementDto>> findAll() {
    return DataSetElementController.super.findAll();
  }

  @Override
  public CRUDProcessor<DataSetElementDto> processor() {
    return dataSetElementProcessor;
  }

  @ApiOperation(value = "Get page Datasets elements", notes = "", response = PageResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = PageResponse.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/element/{id}/page",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<PageResponse<DataSetElementDto>> page(@ApiParam(value = "id", required = true)
                                                              @PathVariable("id") Long dataSetId,
                                                              @ApiParam(value = "offset", required = false)
                                                              @RequestParam("offset") Integer offset,
                                                              @ApiParam(value = "limit", required = false)
                                                              @RequestParam("limit") Integer limit) {
    return dataSetElementProcessor.page(dataSetId, offset, limit);
  }
}
