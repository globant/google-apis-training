package com.globant.training.google.maps.configs;

import com.google.api.server.spi.Constant;

/**
 * Contains the client IDs and scopes for allowed clients consuming the helloworld API.
 */
public class Constants {
  
  /**
   * @WEB_CLIENT_ID@ is a token to be replaced on deployment.
   */
  public static final String WEB_CLIENT_ID = "@WEB_CLIENT_ID@";
  public static final String EMAIL_SCOPE = Constant.API_EMAIL_SCOPE;
  public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;
  public static final String TRACK_POINT_ADDED_QUEUE = "trackpoints-added";
  public static final String JSON_CREDENTIALS_PATH = "@JSON_CREDENTIALS_PATH@";

}

