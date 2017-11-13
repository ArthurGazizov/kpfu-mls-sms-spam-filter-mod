package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.web.utils;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfException;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface SsfControllerAdvice {
  ResponseEntity<ErrorDto> handleUnknownException(Exception exception);

  ResponseEntity<ErrorDto> handleKpfuMlsSsfException(KpfuMlsSsfException kpfuMlsSsfException);
}
