package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public enum KpfuMlsSsfError {
  UNSPECIFIED(1_000_001, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

  DATA_SET_NOT_FOUND(1_001_001, HttpStatus.NOT_FOUND, "Data set not found"),

  DATA_SET_ELEMENT_NOT_FOUND(1_001_002, HttpStatus.NOT_FOUND, "Data set element not found"),

  SMS_TAG_NOT_FOUND(1_001_003, HttpStatus.NOT_FOUND, "Sms tag not found"),

  VALIDATION_ERROR(1_002_001, HttpStatus.BAD_REQUEST, "Validation Error"),

  IO_EXCEPTION(1_010_001, HttpStatus.BAD_REQUEST, "Can't read file"),

  UNSUPPORTED_OPERATION(1_900_001, HttpStatus.BAD_REQUEST, "Unsupported operation");

  private int code;
  private HttpStatus httpStatus;
  private String defaultMessage;

  KpfuMlsSsfError(int code, HttpStatus httpStatus, String defaultMessage) {
    this.code = code;
    this.httpStatus = httpStatus;
    this.defaultMessage = defaultMessage;
  }

  public int getCode() {
    return code;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }

  public KpfuMlsSsfException exception() {
    return new KpfuMlsSsfException(this);
  }

  public KpfuMlsSsfException exception(String message) {
    return new KpfuMlsSsfException(this, message);
  }

  public KpfuMlsSsfException exception(String message, Throwable throwable) {
    return new KpfuMlsSsfException(this, message, throwable);
  }
}
