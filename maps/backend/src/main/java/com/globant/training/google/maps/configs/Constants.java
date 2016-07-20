package com.globant.training.google.maps.configs;

import com.google.api.server.spi.Constant;

/**
 * Contains the client IDs and scopes for allowed clients consuming the helloworld API.
 */
public class Constants {
  
  /**
   * 1058583912977-upoulnl93armugnho0i1epirec4158am.apps.googleusercontent.com is a token to be replaced on deployment.
   */
  public static final String WEB_CLIENT_ID = "1058583912977-upoulnl93armugnho0i1epirec4158am.apps.googleusercontent.com";
  
  public static final String EMAIL_SCOPE = Constant.API_EMAIL_SCOPE;
  public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;
  
}

