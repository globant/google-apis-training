package com.globant.training.google.maps.endpoints.dtos;

/**
 * Base Dto interface.
 * 
 * @author gabriel.sideri
 */
public interface Dto<E> {

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
  void fromEntity(E entity);



}
