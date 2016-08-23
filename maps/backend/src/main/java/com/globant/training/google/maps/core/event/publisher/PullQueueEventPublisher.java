package com.globant.training.google.maps.core.event.publisher;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import com.globant.training.google.maps.core.util.SerializationHelper;

import java.io.Serializable;

/**
 * Pull queue event publisher implementation.
 *
 * @param <E> entity to be published.
 * @param <D> dto to be used in publication.
 * 
 * @author gaston.aguilera
 */
public abstract class PullQueueEventPublisher<E, D extends Serializable>
    implements EventPublisher<E> {

  private static SerializationHelper serializer = SerializationHelper.getDefaultInstance();

  /**
   * Get the queue name where the publication is made.
   * @return a queue name.
   */
  public abstract String getQueueName();

  /**
   * Converts an entity to a dto event.
   * It's called before publication.
   * 
   * @param domain domain entity.
   * @return D the dto to be published.
   */
  public abstract D getEventDto(E domain);

  @Override
  public void publish(E entity) {
    Queue queue = QueueFactory.getQueue(getQueueName());

    D eventDto = getEventDto(entity);
    queue.add(TaskOptions.Builder.withMethod(TaskOptions.Method.PULL)
        .payload(serializer.serialize(eventDto)));
  }
}
