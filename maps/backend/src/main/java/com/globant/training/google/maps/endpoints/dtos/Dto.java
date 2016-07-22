package com.globant.training.google.maps.endpoints.dtos;

/**
 * Base Dto interface.
 * 
 * @author gabriel.sideri
 */
public interface Dto<E> {
  
  /**
   * @return the converted entity from dto.
   */
  E toEntity();
  
  /**
   * Fills the dto from entity values.
   * 
   * @param entity
   */
  void fromEntity(E entity);
  
  

}
