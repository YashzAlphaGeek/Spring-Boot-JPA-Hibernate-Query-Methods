package com.yash.bestcar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Yashwanth
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * @param message - Error Message
   */
  public ResourceNotFoundException(final String message) {
    super(message);
  }
}