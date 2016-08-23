package com.globant.training.google.maps.trackpoint.service.publisher;

import com.globant.training.google.maps.core.event.publisher.PushQueueEventPublisher;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;
import com.globant.training.google.maps.trackpoint.service.worker.TrackPointWorker;

/**
 * TrackPointPushPublisher push implementation.
 * 
 * @author gaston.aguilera
 *
 */
public class TrackPointPushPublisher extends
    PushQueueEventPublisher<TrackPoint, TrackPointAddedEvent> implements TrackPointPublisher {

  @Override
  public TrackPointAddedEvent getEventDto(TrackPoint trackpoint) {
    return TrackPointAddedEvent.fromTrackPoint(trackpoint);
  }

  @Override
  public String getWorkerUrl() {
    return TrackPointWorker.WORKER_URL;
  }

}
