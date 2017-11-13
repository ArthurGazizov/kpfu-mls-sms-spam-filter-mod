package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.web.utils;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@ControllerAdvice
public class SsfControllerAdviceImpl implements SsfControllerAdvice {
  private ResponseEntity<ErrorDto> generateResponse(Throwable throwable) {
    if (throwable instanceof KpfuMlsSsfException) {
      final KpfuMlsSsfException kpfuMlsSsfException = (KpfuMlsSsfException) throwable;
      final ErrorDto errorDto = ErrorDto.Builder.anErrorDto()
              .errorId(UUID.randomUUID().toString())
              .code(kpfuMlsSsfException.getCode())
              .message(kpfuMlsSsfException.getMessage())
              .build();
      return new ResponseEntity<>(errorDto, kpfuMlsSsfException.getStatus());
    } else {
      final ErrorDto errorDto = ErrorDto.Builder.anErrorDto()
              .errorId(UUID.randomUUID().toString())
              .code(-1)
              .message(throwable.getMessage())
              .build();
      return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorDto> handleUnknownException(Exception exception) {
    return this.generateResponse(exception);
  }

  @Override
  @ExceptionHandler({KpfuMlsSsfException.class})
  public ResponseEntity<ErrorDto> handleKpfuMlsSsfException(KpfuMlsSsfException kpfuMlsSsfException) {
    return this.generateResponse(kpfuMlsSsfException);
  }
}
