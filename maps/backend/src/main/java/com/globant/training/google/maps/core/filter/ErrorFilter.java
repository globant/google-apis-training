package com.globant.training.google.maps.core.filter;

import com.globant.training.google.maps.core.exception.MapsServiceException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * Filter to process {@link MapsServiceException} exception.
 */
public class ErrorFilter implements Filter {

  private static final Logger logger = Logger.getLogger(ErrorFilter.class.getName());

  /**
   * TODO move to a json object or similar.
   * This problem is related with spi gae endpoints.
   * They provide only custom checked exception. 
   * There is no way of throwing an error with a runtime exception, 
   * and as we are using validations on
   * Api Transformers we end with this work around, and must be changed.
   * 
   */
  private static final String ERROR_TPL = "{"
      + "  \"error\": {"
      + "    \"errors\": ["
      + "      {"
      + "        \"domain\": \"global\","
      + "        \"reason\": \"backendError\","
      + "        \"message\": \"%s\""
      + "      }"
      + "    ],"
      + "    \"code\": %s,"
      + "    \"message\": \"%s\""
      + "  }"
      + "}";
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    try {
      
      chain.doFilter(request, response);
      
    } catch (Throwable exception) {
      
      

      if (exception instanceof MapsServiceException) {
        
        // Level Fine as is a bussiness exception.
        logger.log(Level.FINE, exception.getMessage(), exception);
        
        MapsServiceException mapsException = (MapsServiceException) exception;
        
        String error = String.format(ERROR_TPL, mapsException.getMessage(),
            mapsException.getErrorCode(), mapsException.getMessage());

        response.getWriter().write(error);
      } else {
        throw exception;
      }
    }
  }

  @Override
  public void destroy() {}


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}
  

}
