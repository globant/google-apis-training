package com.globant.training.google.maps.core.exception;

import org.apache.http.HttpStatus;

/**
 * Generic validation error with BAD_REQUEST (400) error code.
 */
public class ValidationException extends MapsServiceException {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param message a message indicating the validation problem.
   */
  public ValidationException(String message) {
    super(HttpStatus.SC_BAD_REQUEST, message);
  }
}
