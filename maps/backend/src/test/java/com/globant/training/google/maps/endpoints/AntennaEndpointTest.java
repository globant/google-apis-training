/**
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.globant.training.google.maps.endpoints;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.globant.training.google.maps.services.AntennaService;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

/**
 * @author gaston.aguilera
 *
 */
public class AntennaEndpointTest {

  private AntennaEndpoint endpoint;
  
  @Mock
  private AntennaService antennaService;

  private final LocalServiceTestHelper helper =
      new LocalServiceTestHelper(new LocalUserServiceTestConfig())
          .setEnvIsLoggedIn(true)
          .setEnvAuthDomain("localhost")
          .setEnvEmail("test@localhost");

  @Before
  public void setupGuestBookServlet() {
    helper.setUp();
    endpoint = new AntennaEndpoint(antennaService);
  }

  @After
  public void tearDownHelper() {
    helper.tearDown();
  }

  @Test
  public void testDoGet() throws IOException {
    // TODO Add test after Objectify is integrated.
  }

}
