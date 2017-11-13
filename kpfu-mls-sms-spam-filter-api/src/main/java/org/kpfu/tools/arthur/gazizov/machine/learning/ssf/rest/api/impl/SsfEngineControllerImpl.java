package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.Probability;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.SsfEngineProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces.SsfEngineController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Controller
@RequestMapping(value = "/v1/ssf/engine", produces = {APPLICATION_JSON_VALUE})
@Api(value = "SsfEngineController", description = "The SsfEngineController API")
public class SsfEngineControllerImpl implements SsfEngineController {
  @Autowired
  private SsfEngineProcessor ssfEngineProcessor;

  @ApiOperation(code = 200, value = "Get probability", notes = "", response = Probability.class)
  @ApiResponses(value = {
          @ApiResponse(code = 202, message = "", response = Probability.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/probability/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<Probability> calculateProbability(@ApiParam(value = "id", required = true)
                                                          @PathVariable("id") Long dataSetId,
                                                          @ApiParam(value = "word", required = true)
                                                          @RequestParam String word,
                                                          @ApiParam(value = "smsTagId", required = true)
                                                          @RequestParam Long smsTagId) {
    return ssfEngineProcessor.calculateProbability(dataSetId, word, smsTagId);
  }

  @ApiOperation(code = 200, value = "Get weight probability", notes = "", response = Probability.class)
  @ApiResponses(value = {
          @ApiResponse(code = 202, message = "", response = Probability.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/weightprobability/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<Probability> calculateWeightProbability(@ApiParam(value = "id", required = true)
                                                                @PathVariable("id") Long dataSetId,
                                                                @ApiParam(value = "word", required = true)
                                                                @RequestParam String word,
                                                                @ApiParam(value = "smsTagId", required = true)
                                                                @RequestParam Long smsTagId) {
    return ssfEngineProcessor.calculateWeightProbability(dataSetId, word, smsTagId);
  }
}
