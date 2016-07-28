package com.globant.training.google.maps.core.endpoint.dto;

/**
 * Base Dto interface.
 * 
 * @author gabriel.sideri
 */
public interface Dto<E, D> {

  /**
   * Convert Dto to Entity.
   * 
   * @return the converted entity from dto.
   */
  E toEntity();

  /**
   * Fills the dto from entity values.
   * 
   * @param entity the entity source to fill the dto
   */
  D fromEntity(E entity);
}
