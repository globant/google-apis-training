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

import com.google.appengine.api.oauth.OAuthRequestException;

import com.globant.training.google.maps.endpoints.dtos.AntennaDto;
import com.globant.training.google.maps.entities.Antenna;
import com.globant.training.google.maps.services.AntennaService;
import com.globant.training.google.maps.services.UserService;

import org.junit.Before;
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
@RunWith(MockitoJUnitRunner.class)
public class AntennaEndpointTest {

  private AntennaEndpoint antennaEndpoint;

  private AntennaDto validAntennaDto;

  private Antenna validAntenna;

  private static final Long INVALID_ANTENNA_ID = 1L;

  private static final Long VALID_ANTENNA_ID = 2L;

  private static final String VALID_ANTENNA_SERIAL_NUMBER = "111222ABC";

  private static final String VALID_ANTENNA_NAME = "WEST ANTENNA 1";

  private static final Double VALID_ANTENNA_LONGITUDE = 120.01;

  private static final Double VALID_ANTENNA_LATITUDE = -31.10;

  private static final Double VALID_ANTENNA_RANGE_LIMIT = 100D;

  @Mock
  private AntennaService antennaServiceMock;
  
  @Mock
  private UserService userServiceMock;

  /**
   * Setup tests.
   */
  @Before
  public void setup() {
    antennaEndpoint = new AntennaEndpoint(antennaServiceMock, userServiceMock);

    validAntenna = new Antenna();
    validAntenna.setId(VALID_ANTENNA_ID);
    validAntenna.setSerialNumber(VALID_ANTENNA_SERIAL_NUMBER);
    validAntenna.setName(VALID_ANTENNA_NAME);
    validAntenna.setLatitude(VALID_ANTENNA_LATITUDE);
    validAntenna.setLongitude(VALID_ANTENNA_LONGITUDE);
    validAntenna.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);

    validAntennaDto = new AntennaDto();
    validAntennaDto.setAntennaId(VALID_ANTENNA_ID);
    validAntennaDto.setSerialNumber(VALID_ANTENNA_SERIAL_NUMBER);
    validAntennaDto.setName(VALID_ANTENNA_NAME);
    validAntennaDto.setLatitude(VALID_ANTENNA_LATITUDE);
    validAntennaDto.setLongitude(VALID_ANTENNA_LONGITUDE);
    validAntennaDto.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);

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
  public void testModifyntennaWithInvalidAntennaId() {
    when(antennaServiceMock.findById(INVALID_ANTENNA_ID)).thenReturn(null);

    antennaEndpoint.modify(INVALID_ANTENNA_ID, validAntennaDto);

    verify(antennaServiceMock).findById(INVALID_ANTENNA_ID);
  }
  
  /**
   * Invoke {@link AntennaEndpoint#modify(Long, AntennaDto)} with valid id and check if
   * {@link AntennaService#findById(Long)} & {@link AntennaService#save(Antenna)} was called.
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
  public void testModifyAntennaWithValidAntennaId() {
    when(antennaServiceMock.findById(VALID_ANTENNA_ID)).thenReturn(validAntenna);

    antennaEndpoint.modify(VALID_ANTENNA_ID, validAntennaDto);

    verify(antennaServiceMock).findById(VALID_ANTENNA_ID);
    verify(antennaServiceMock).save(validAntenna);
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
  public void testDeleteAntennaWithValidAntennaId() {
    when(antennaServiceMock.findById(VALID_ANTENNA_ID)).thenReturn(validAntenna);

    antennaEndpoint.deleteAntenna(VALID_ANTENNA_ID);

    verify(antennaServiceMock).findById(VALID_ANTENNA_ID);
    verify(antennaServiceMock).deleteById(VALID_ANTENNA_ID);
  }
  
  /**
   * Invoke {@link AntennaEndpoint#deleteAntenna(Long)} with invalid id and return an
   * exception.
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
  public void testDeleteAntennaWithInvalidAntennaId() {
    when(antennaServiceMock.findById(INVALID_ANTENNA_ID)).thenReturn(null);

    antennaEndpoint.deleteAntenna(INVALID_ANTENNA_ID);

    verify(antennaServiceMock).findById(INVALID_ANTENNA_ID);
  }
  
  /**
   * Invoke {@link AntennaEndpoint#addAntenna(AntennaDto)} with empty mandatory values
   * and return an exception.
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
  public void testAddAntennaWithEmptyMandatoryValues() {
    AntennaDto newAntenna = new AntennaDto();
    newAntenna.setLatitude(VALID_ANTENNA_LATITUDE);
    newAntenna.setLongitude(VALID_ANTENNA_LONGITUDE);
    newAntenna.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);
   
    antennaEndpoint.addAntenna(newAntenna);
    
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
  public void testAddAntennaWithValidValues() {
    AntennaDto newAntenna = new AntennaDto();
    newAntenna.setSerialNumber(VALID_ANTENNA_SERIAL_NUMBER);
    newAntenna.setName(VALID_ANTENNA_NAME);
    newAntenna.setLatitude(VALID_ANTENNA_LATITUDE);
    newAntenna.setLongitude(VALID_ANTENNA_LONGITUDE);
    newAntenna.setRangeLimit(VALID_ANTENNA_RANGE_LIMIT);
    
    when(antennaServiceMock.save(newAntenna.toEntity())).thenReturn(validAntenna);

    AntennaDto response = antennaEndpoint.addAntenna(newAntenna);

    verify(antennaServiceMock).save(any(Antenna.class));
    assertNotNull(response);
    antennaDtoValidation(response);
  }

  /**
   * Invoke {@link AntennaEndpoint#findAntennas()} and return a List of
   * {@link AntennaDto}.
   * 
   * <pre>
   * Scenario:
   *      1) Try to invoke {@link AntennaEndpoint#findAntennas()} 
   * Expectations:
   *      1) List of {@link AntennaDto} is returned.
   * </pre>
   */
  @Test
  public void testFindAllAntennas() {
    List<Antenna> antennas = new ArrayList<>();
    antennas.add(validAntenna); 
    
    when(antennaServiceMock.getAll()).thenReturn(antennas);

    List<AntennaDto> response = antennaEndpoint.findAntennas();

    verify(antennaServiceMock).getAll();
    
    assertNotNull(response);
    assertFalse(response.isEmpty());
    antennaDtoValidation(response.get(0));
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

    antennaEndpoint.getAntenna(INVALID_ANTENNA_ID);

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

    AntennaDto response = antennaEndpoint.getAntenna(VALID_ANTENNA_ID);

    verify(antennaServiceMock).findById(VALID_ANTENNA_ID);
    assertNotNull(response);
    antennaDtoValidation(response);
  }

  /**
   * Validates if a {@link AntennaDto} has a valid information.
   * 
   * @param antenna the dto to be validate it.
   */
  private void antennaDtoValidation(AntennaDto antenna) {
    assertEquals(antenna.getId(), VALID_ANTENNA_ID);
    assertEquals(antenna.getName(), VALID_ANTENNA_NAME);
    assertEquals(antenna.getSerialNumber(), VALID_ANTENNA_SERIAL_NUMBER);
    assertEquals(antenna.getLatitude(), VALID_ANTENNA_LATITUDE);
    assertEquals(antenna.getLongitude(), VALID_ANTENNA_LONGITUDE);
    assertEquals(antenna.getRangeLimit(), VALID_ANTENNA_RANGE_LIMIT);
  }

}
