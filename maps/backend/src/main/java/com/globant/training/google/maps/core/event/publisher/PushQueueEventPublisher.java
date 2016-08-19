package com.globant.training.google.maps.core.event.publisher;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import com.globant.training.google.maps.core.util.SerializationHelper;

import java.io.Serializable;

/**
 * Push queue event publisher implementation.
 *
 * @param <E> entity to be published.
 * @param <D> dto to be used in publication.
 * 
 * @author gaston.aguilera
 */
public abstract class PushQueueEventPublisher<E, D extends Serializable>
    implements EventPublisher<E> {

  private static SerializationHelper serializer = SerializationHelper.getDefaultInstance();

  /**
   * Converts an entity to a dto event.
   * It's called before publication.
   * 
   * @param domain domain entity.
   * @return D the dto to be published.
   */
  public abstract D getEventDto(E domain);
  
  /**
   * Get the worker path where the publication is made.
   * @return a worker path.
   */
  public abstract String getWorkerUrl();

  @Override
  public void publish(E entity) {
    Queue queue = QueueFactory.getDefaultQueue();
    D eventDto = getEventDto(entity);

    queue.add(TaskOptions.Builder.withUrl(getWorkerUrl())
        .payload(serializer.serialize(eventDto)));
  }


}
