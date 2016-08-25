package com.globant.training.google.maps.trackpoint.service.worker;

import com.google.inject.Inject;

import com.globant.training.google.maps.alert.service.AlertProcessorService;
import com.globant.training.google.maps.core.event.worker.BaseWorker;
import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;

import java.util.logging.Logger;

/**
 * TrackPointWorker implementation to be used in combination with TrackPointPushPublisher.
 * 
 * @author gaston.aguilera
 *
 */
public class TrackPointWorker extends BaseWorker<TrackPointAddedEvent> {
  
  public static final String WORKER_URL = "/tasks/process-entrypoint";

  private static final long serialVersionUID = 1L;

  private Logger logger = Logger.getLogger(TrackPointWorker.class.getName());

  private final AlertProcessorService alertProcessorService;

  @Inject
  public TrackPointWorker(AlertProcessorService alertProcessorService) {
    this.alertProcessorService = alertProcessorService;
  }

  @Override
  public void process(TrackPointAddedEvent dto) {
    logger.info("procesing entry point for item" + dto.getItemId());

    alertProcessorService.process(dto);

    logger.info("entry point for item" + dto.getItemId() + " processed");

  }
}
