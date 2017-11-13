package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.SmsTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.base.CRUDProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.SmsTagProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces.SmsTagController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Controller
@RequestMapping(value = "/v1/ssf/", produces = {APPLICATION_JSON_VALUE})
@Api(value = "SmsTagController", description = "The SmsTagController API")
public class SmsTagControllerImpl implements SmsTagController {
  @Autowired
  private SmsTagProcessor smsTagProcessor;

  @ApiOperation(value = "Get Sms tag", notes = "", response = SmsTagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = SmsTagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<SmsTagDto> get(@ApiParam(value = "id", required = true)
                                       @PathVariable("id") Long id) {
    return SmsTagController.super.get(id);
  }

  @ApiOperation(value = "Save Sms tag", notes = "", response = SmsTagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = SmsTagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<SmsTagDto> save(@ApiParam(value = "smsTagDto", required = true)
                                        @RequestBody SmsTagDto smsTagDto) {
    return SmsTagController.super.save(smsTagDto);
  }

  @ApiOperation(value = "Update Sms tag", notes = "", response = SmsTagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = SmsTagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag",
          produces = {"application/json"},
          method = RequestMethod.PUT)
  @Override
  public ResponseEntity<SmsTagDto> update(@ApiParam(value = "smsTagDto", required = true)
                                          @RequestBody SmsTagDto smsTagDto) {
    return SmsTagController.super.update(smsTagDto);
  }

  @ApiOperation(value = "Patch Sms tag", notes = "", response = SmsTagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = SmsTagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag",
          produces = {"application/json"},
          method = RequestMethod.PATCH)
  @Override
  public ResponseEntity<SmsTagDto> patch(@ApiParam(value = "smsTagDto", required = true)
                                         @RequestBody SmsTagDto smsTagDto) {
    return SmsTagController.super.patch(smsTagDto);
  }

  @ApiOperation(value = "Get Sms tag", notes = "", response = SmsTagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = SmsTagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/{id}",
          produces = {"application/json"},
          method = RequestMethod.DELETE)
  @Override
  public ResponseEntity<Void> delete(@ApiParam(value = "id", required = true)
                                     @PathVariable("id") Long id) {
    return SmsTagController.super.delete(id);
  }

  @ApiOperation(value = "Get Sms tag", notes = "", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = List.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/all",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<List<SmsTagDto>> findAll() {
    return SmsTagController.super.findAll();
  }

  @Override
  public CRUDProcessor<SmsTagDto> processor() {
    return smsTagProcessor;
  }
}
