package com.globant.training.google.maps.core.exception;

/**
 * Runtime exception to be throw on service with a http code. Use the same codes of app engine
 * https://cloud.google.com/appengine/docs/java/endpoints/exceptions
 */
public class MapsServiceException extends RuntimeException {

  private final int errorCode;

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param errorCode the exception error code.
   */
  public MapsServiceException(int errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  /**
   * Gets the error code for exception.
   * 
   * @return an error code.
   */
  public int getErrorCode() {
    return errorCode;
  }

}
