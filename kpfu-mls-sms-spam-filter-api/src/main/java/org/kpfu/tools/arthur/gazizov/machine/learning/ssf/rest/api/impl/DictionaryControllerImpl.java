package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.DictionaryProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.api.interfaces.DictionaryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Controller
@RequestMapping(value = "/v1/ssf/dictionary", produces = {APPLICATION_JSON_VALUE})
@Api(value = "DictionaryController", description = "The DictionaryController API")
public class DictionaryControllerImpl implements DictionaryController {
  @Autowired
  private DictionaryProcessor dictionaryProcessor;

  @ApiOperation(code = 202, value = "Save Dataset", notes = "")
  @ApiResponses(value = {
          @ApiResponse(code = 202, message = ""),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/apply/{id}",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<Void> apply(@ApiParam(value = "id", required = true)
                                    @PathVariable("id") Long dataSetId) {
    return dictionaryProcessor.apply(dataSetId);
  }

  @ApiOperation(code = 200, value = "Save Dataset", notes = "", response = TagsStat.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = TagsStat.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tagstat/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<TagsStat> getTagStat(@ApiParam(value = "id", required = true)
                                             @PathVariable("id") Long dataSetId) {
    return dictionaryProcessor.getTagStat(dataSetId);
  }

  @ApiOperation(code = 200, value = "Save Dataset", notes = "", response = WordsStat.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = WordsStat.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/wordstat/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<WordsStat> getWordsStat(@ApiParam(value = "id", required = true)
                                                @PathVariable("id") Long dataSetId) {
    return dictionaryProcessor.getWordsStat(dataSetId);
  }
}
