package com.globant.training.google.maps.trackpoint.service.worker;

import com.google.inject.Inject;

import com.globant.training.google.maps.core.event.worker.BaseWorker;
import com.globant.training.google.maps.trackpoint.heatmap.HeatmapService;
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

  private final HeatmapService heatmapService;

  @Inject
  public TrackPointWorker(HeatmapService heatmapService) {
    this.heatmapService = heatmapService;
  }

  @Override
  public void process(TrackPointAddedEvent dto) {
    logger.info("procesing entry point for item" + dto.getItemId());
    
    //TODO add alarm processor.

    logger.info("entry point for item" + dto.getItemId() + " processed");

  }
}
