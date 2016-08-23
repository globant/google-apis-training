package com.globant.training.google.maps.core.event.publisher;

/**
 * Event publisher generic inteface.
 *
 * @param <E> type to be published.
 * 
 * @author gaston.aguilera
 */
public interface EventPublisher<E> {
  /**
   * Publish a event
   * 
   * @param event to be published.
   */
  void publish(E event);
}
