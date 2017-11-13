package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public class KpfuMlsSsfException extends RuntimeException {
  private final KpfuMlsSsfError error;

  KpfuMlsSsfException(KpfuMlsSsfError error, String message, Throwable cause) {
    super(message, cause);
    this.error = error;
  }

  KpfuMlsSsfException(String message) {
    this(KpfuMlsSsfError.UNSPECIFIED, message, null);
  }

  KpfuMlsSsfException(KpfuMlsSsfError error, String message) {
    this(error, message, null);
  }

  KpfuMlsSsfException(KpfuMlsSsfError error) {
    this(error, error.getDefaultMessage(), null);
  }

  public KpfuMlsSsfError getError() {
    return error;
  }

  public HttpStatus getStatus() {
    return error.getHttpStatus();
  }

  public int getCode() {
    return error.getCode();
  }
}
