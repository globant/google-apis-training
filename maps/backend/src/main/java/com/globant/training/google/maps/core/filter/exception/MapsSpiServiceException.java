package com.globant.training.google.maps.core.filter.exception;

import com.google.api.server.spi.ServiceException;

/**
 * Custom app engine ServiceException. The custom exceptions of gae is done by by subclassing
 * {@link ServiceException} This class is used in Error Filter to be fully compatible with gae, and
 * must not be used for other proposes.
 * 
 * @author gastonaguilera
 *
 */
public class MapsSpiServiceException extends ServiceException {

  private static final long serialVersionUID = 1L;

  public MapsSpiServiceException(int statusCode, String statusMessage) {
    super(statusCode, statusMessage);
  }
}
