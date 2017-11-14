package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.impl;

import com.fasterxml.jackson.databind.node.TextNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param.ClassificationMethod;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param.Message;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.ClassificationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.ClassificationProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces.ClassificationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
@Controller
@RequestMapping(value = "/v1/ssf", produces = {APPLICATION_JSON_VALUE})
@Api(value = "DataSetController", description = "The DataSetController API")
public class ClassificationControllerImpl implements ClassificationController {
  @Autowired
  private ClassificationProcessor classificationProcessor;

  @ApiOperation(code = 200, value = "Get weight probability", notes = "", response = ClassificationReport.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = ClassificationReport.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/classify/{id}",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<ClassificationReport> classify(@ApiParam(value = "id", required = true)
                                                       @PathVariable("id") Long dataSetId,
                                                       @ApiParam(value = "message", required = true)
                                                       @RequestBody Message message,
                                                       @ApiParam(value = "method", required = true,
                                                               allowableValues = "FISHER_CLASSIFICATION,BAYES_CLASSIFICATION")
                                                       @RequestParam String method,
                                                       @ApiParam(value = "useWeight", required = true)
                                                       @RequestParam Boolean useWeight) {
    return classificationProcessor.classify(dataSetId, message.getSms(), ClassificationMethod.valueOf(method), useWeight);
  }
}
