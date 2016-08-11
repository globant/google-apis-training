/**
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.globant.training.google.maps.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.oauth.OAuthRequestException;

import com.globant.training.google.maps.antenna.endpoint.AntennaEndpoint;
import com.globant.training.google.maps.antenna.endpoint.dtos.AntennaDto;
import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.antenna.service.AntennaService;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.entity.UserRole;
import com.globant.training.google.maps.user.service.UserService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * Antenna Endpoint Unit Test.
 * 
 * @author gaston.aguilera
 */
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class AntennaEndpointTest {

  private AntennaEndpoint antennaEndpoint;

  private Antenna validAntennaRequest;

  private Antenna validAntenna;

  private User authenticatedUser;

  private  AppUser loggedUser;

  private static final Long INVALID_ANTENNA_ID = 1L;

  private static final Long VALID_ANTENNA_ID = 2L;

  private static final String VALID_ANTENNA_SERIAL_NUMBER = "111222ABC";

  private static final String VALID_ANTENNA_NAME = "WEST ANTENNA 1";

  private static final Double VALID_ANTENNA_LONGITUDE = 120.01;

  private static final Double VALID_ANTENNA_LATITUDE = -31.10;

  private static final Double VALID_ANTENNA_RANGE_LIMIT = 100D;

  private static final String EMAIL_USER = "user@gmail.com";

  private static final String GOOGLE_ID = "1112222CCCC2";

  @Mock
  private AntennaService antennaServiceMock;

  @Mock
  private UserService userServiceMock;

  /**
   * Setup tests.
   * 
   * @throws OAuthRequestException returns exception if the user is no logged
   */
  @Before
  public void setup() throws OAuthRequestException {
    antennaEndpoint = new AntennaEndpoint(antennaServiceMock, userServiceMock);

    validAntenna = new Antenna();
    validAntenna.setId(VALID_ANTENNA_ID);
    validAntenna.setSerialNumber(VALID_ANTENNA_SERIAL_NUMBER);
    validAntenna.setName(VALID_ANTENNA_NAME);
    validAntenna.setLatitude(VALID_ANTENNA_LATITUDE);
    validAntenna.setLongitude(VALID_ANTENNA_LONGITUDE);
    validAntenna.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);

    validAntennaRequest = new Antenna();
    validAntennaRequest.setId(VALID_ANTENNA_ID);
    validAntennaRequest.setSerialNumber(VALID_ANTENNA_SERIAL_NUMBER);
    validAntennaRequest.setName(VALID_ANTENNA_NAME);
    validAntennaRequest.setLatitude(VALID_ANTENNA_LATITUDE);
    validAntennaRequest.setLongitude(VALID_ANTENNA_LONGITUDE);
    validAntennaRequest.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);

    authenticatedUser = new User(GOOGLE_ID, EMAIL_USER);

    loggedUser = new AppUser(GOOGLE_ID, EMAIL_USER);
    loggedUser.getRoles().add(UserRole.ADMIN);
    
    when(userServiceMock.findUserByGoogleId(GOOGLE_ID)).thenReturn(loggedUser);
    
  }

  /**
   * Invoke {@link AntennaEndpoint#modify(Long, AntennaDto)} with invalid id and return an
   * exception.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#modify(Long, AntennaDto)} 
   *      with a invalid antenna id.
   * Expectations:
   *      1) Exception is returned.
   * </pre>
   */
  @Test(expected = RuntimeException.class)
  public void testModifyntennaWithInvalidAntennaId() throws OAuthRequestException {
    when(antennaServiceMock.findById(INVALID_ANTENNA_ID)).thenReturn(null);

    antennaEndpoint.modify(INVALID_ANTENNA_ID, validAntennaRequest, authenticatedUser);

    verify(antennaServiceMock).findById(INVALID_ANTENNA_ID);
  }

  /**
   * Invoke {@link AntennaEndpoint#modify(Long, AntennaDto)} with valid id and check if
   * {@link AntennaService#findById(Long)} & {@link AntennaService#save(AntennaDto)} was called.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke  {@link AntennaEndpoint#modify(Long, AntennaDto)}
   *      with a valid antenna id.
   * Expectations:
   *      1)  {@link AntennaService#findById(Long)} was called.  
   *      2)  {@link AntennaService#modify(Long, AntennaDto)} was called.
   * </pre>
   */
  @Test
  public void testModifyAntennaWithValidAntennaId() throws OAuthRequestException {
    when(antennaServiceMock.findById(VALID_ANTENNA_ID)).thenReturn(validAntenna);

    antennaEndpoint.modify(VALID_ANTENNA_ID, validAntennaRequest, authenticatedUser);

    verify(antennaServiceMock).findById(VALID_ANTENNA_ID);
    verify(antennaServiceMock).update(VALID_ANTENNA_ID, validAntenna);
  }

  /**
   * Invoke {@link AntennaEndpoint#deleteAntenna(Long)} with valid id and check if
   * {@link AntennaService#findById(Long)} & {@link AntennaService#deleteById(Long)} was called.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#deleteAntenna(Long)} 
   *      with a valid antenna id.
   * Expectations:
   *      1)  {@link AntennaService#findById(Long)} was called.  
   *      2)  {@link AntennaService#deleteById(Long)} was called.
   * </pre>
   */
  @Test
  public void testDeleteAntennaWithValidAntennaId() throws OAuthRequestException {
    when(antennaServiceMock.findById(VALID_ANTENNA_ID)).thenReturn(validAntenna); 
   
    antennaEndpoint.deleteAntenna(VALID_ANTENNA_ID, authenticatedUser);

    verify(antennaServiceMock).findById(VALID_ANTENNA_ID);
    verify(antennaServiceMock).deleteById(VALID_ANTENNA_ID);
  }

  /**
   * Invoke {@link AntennaEndpoint#deleteAntenna(Long)} with invalid id and return an exception.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#deleteAntenna(Long)} 
   *      with a invalid antenna id.
   * Expectations:
   *      1) Exception is returned.
   * </pre>
   */
  @Test(expected = RuntimeException.class)
  public void testDeleteAntennaWithInvalidAntennaId() throws OAuthRequestException {
    when(antennaServiceMock.findById(INVALID_ANTENNA_ID)).thenReturn(null);

    antennaEndpoint.deleteAntenna(INVALID_ANTENNA_ID, authenticatedUser);

    verify(antennaServiceMock).findById(INVALID_ANTENNA_ID);
  }

  /**
   * Invoke {@link AntennaEndpoint#addAntenna(AntennaDto)} with empty mandatory values and return an
   * exception.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#addAntenna(AntennaDto)} 
   *       with empty mandatory values (name & serial number).
   * Expectations:
   *      1) Exception is returned.
   * </pre>
   */
  @Test(expected = RuntimeException.class)
  public void testAddAntennaWithEmptyMandatoryValues() throws OAuthRequestException {
    Antenna newAntenna = new Antenna();
    newAntenna.setLatitude(VALID_ANTENNA_LATITUDE);
    newAntenna.setLongitude(VALID_ANTENNA_LONGITUDE);
    newAntenna.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);

    antennaEndpoint.addAntenna(newAntenna, authenticatedUser);

  }

  /**
   * Invoke {@link AntennaEndpoint#addAntenna(AntennaDto)} with valid values and return a
   * {@link AntennaDto} with the new id.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#addAntenna(AntennaDto)} 
   *      with a valid values.
   * Expectations:
   *      1) {@link AntennaDto} is returned.
   * </pre>
   */
  @Test
  public void testAddAntennaWithValidValues() throws OAuthRequestException {
    Antenna newAntenna = new Antenna();
    newAntenna.setSerialNumber(VALID_ANTENNA_SERIAL_NUMBER);
    newAntenna.setName(VALID_ANTENNA_NAME);
    newAntenna.setLatitude(VALID_ANTENNA_LATITUDE);
    newAntenna.setLongitude(VALID_ANTENNA_LONGITUDE);
    newAntenna.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);

    when(antennaServiceMock.create(newAntenna)).thenReturn(validAntenna);

    Antenna response = antennaEndpoint.addAntenna(newAntenna, authenticatedUser);

    verify(antennaServiceMock).create(any(Antenna.class));
    assertNotNull(response);
    antennaValidation(response);
  }

  /**
   * Invoke {@link AntennaEndpoint#findAntennas()} and return a List of {@link AntennaDto}.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#findAntennas()} 
   * Expectations:
   *      1) List of {@link AntennaDto} is returned.
   * </pre>
   */
  @Test
  public void testFindAllAntennas() throws OAuthRequestException {
    List<Antenna> antennas = new ArrayList<>();
    antennas.add(validAntenna);

    when(antennaServiceMock.getAll()).thenReturn(antennas);

    List<Antenna> response = antennaEndpoint.findAntennas(authenticatedUser);

    verify(antennaServiceMock).getAll();

    assertNotNull(response);
    assertFalse(response.isEmpty());
    antennaValidation(response.get(0));
  }

  /**
   * Invoke {@link AntennaEndpoint#getAntenna(Long)} with invalid parameters and return an
   * exception.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#getAntenna(Long)} 
   *      with a invalid antenna id.
   * Expectations:
   *      1) Exception is returned.
   * </pre>
   */
  @Test(expected = RuntimeException.class)
  public void testGetAntennaWithInvalidAntennaId() throws OAuthRequestException {
    when(antennaServiceMock.findById(INVALID_ANTENNA_ID)).thenReturn(null);

    antennaEndpoint.getAntenna(INVALID_ANTENNA_ID, authenticatedUser);

    verify(antennaServiceMock).findById(INVALID_ANTENNA_ID);
  }

  /**
   * Invoke {@link AntennaEndpoint#getAntenna(Long)} with valid parameters and return a
   * {@link AntennaDto}.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#getAntenna(Long)} 
   *      with a valid antenna id.
   * Expectations:
   *      1) {@link AntennaDto} is returned.
   * </pre>
   */
  @Test
  public void testGetAntennaWithValidAntennaId() throws OAuthRequestException {
    when(antennaServiceMock.findById(VALID_ANTENNA_ID)).thenReturn(validAntenna);

    Antenna response = antennaEndpoint.getAntenna(VALID_ANTENNA_ID, authenticatedUser);

    verify(antennaServiceMock).findById(VALID_ANTENNA_ID);
    assertNotNull(response);
    antennaValidation(response);
  }

  /**
   * Validates if a {@link AntennaDto} has a valid information.
   * 
   * @param antenna the dto to be validate it.
   */
  private void antennaValidation(Antenna antenna) {
    assertEquals(antenna.getId(), VALID_ANTENNA_ID);
    assertEquals(antenna.getName(), VALID_ANTENNA_NAME);
    assertEquals(antenna.getSerialNumber(), VALID_ANTENNA_SERIAL_NUMBER);
    assertEquals(antenna.getLatitude(), VALID_ANTENNA_LATITUDE);
    assertEquals(antenna.getLongitude(), VALID_ANTENNA_LONGITUDE);
    assertEquals(antenna.getRangeLimit(), VALID_ANTENNA_RANGE_LIMIT);
  }

}
