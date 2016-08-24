package com.globant.training.google.maps.configs;


import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import com.googlecode.objectify.ObjectifyFilter;

import com.globant.training.google.maps.alert.dao.AlertDao;
import com.globant.training.google.maps.alert.dao.objectify.AlertOfyDao;
import com.globant.training.google.maps.alert.endpoint.AlertEndpoint;
import com.globant.training.google.maps.alert.service.AlertService;
import com.globant.training.google.maps.alert.service.AlertServiceImpl;
import com.globant.training.google.maps.antenna.dao.AntennaDao;
import com.globant.training.google.maps.antenna.dao.objectify.AntennaOfyDao;
import com.globant.training.google.maps.antenna.endpoint.AntennaEndpoint;
import com.globant.training.google.maps.antenna.service.AntennaService;
import com.globant.training.google.maps.antenna.service.AntennaServiceImpl;
import com.globant.training.google.maps.configs.endpoint.ConfigEndpoint;
import com.globant.training.google.maps.core.dao.objectify.OfyService;
import com.globant.training.google.maps.core.filter.ErrorFilter;
import com.globant.training.google.maps.device.daos.DeviceDao;
import com.globant.training.google.maps.device.daos.objectify.DeviceOfyDao;
import com.globant.training.google.maps.device.endpoint.DeviceEndpoint;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.device.service.DeviceServiceImpl;
import com.globant.training.google.maps.fusiontables.service.FusionTablesService;
import com.globant.training.google.maps.fusiontables.service.FusionTablesServiceImpl;
import com.globant.training.google.maps.item.dao.ItemDao;
import com.globant.training.google.maps.item.dao.objectify.ItemOfyDao;
import com.globant.training.google.maps.item.endpoint.ItemEndpoint;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.item.service.ItemServiceImpl;
import com.globant.training.google.maps.trackpoint.dao.TrackPointDao;
import com.globant.training.google.maps.trackpoint.dao.objectify.TrackPointOfyDao;
import com.globant.training.google.maps.trackpoint.endpoint.TrackPointEndpoint;
import com.globant.training.google.maps.trackpoint.heatmap.HeatMapServiceFusionTablesService;
import com.globant.training.google.maps.trackpoint.heatmap.HeatmapService;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;
import com.globant.training.google.maps.trackpoint.service.TrackPointServiceImpl;
import com.globant.training.google.maps.trackpoint.service.publisher.TrackPointPublisher;
import com.globant.training.google.maps.trackpoint.service.publisher.TrackPointPushPublisher;
import com.globant.training.google.maps.trackpoint.service.visitor.TrackPointProcessorVisitor;
import com.globant.training.google.maps.trackpoint.service.visitor.TrackPointVisitor;
import com.globant.training.google.maps.trackpoint.service.worker.TrackPointWorker;
import com.globant.training.google.maps.user.dao.UserDao;
import com.globant.training.google.maps.user.dao.objectify.UserOfyDao;
import com.globant.training.google.maps.user.endpoint.UserEndpoint;
import com.globant.training.google.maps.user.service.UserService;
import com.globant.training.google.maps.user.service.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;


/**
 * GuiceServletContextListener for configuring guice.
 * 
 * @author gabriel.sideri
 *
 */
public class GuiceConfig extends GuiceServletContextListener {

  private static final Logger log = Logger.getLogger(GuiceConfig.class.getName());

  /**
   * Servlets configuration. All the servlets definitions must be configurated here.
   *
   */
  static class MapsServletModule extends GuiceSystemServiceServletModule {

    @Override
    protected void configureServlets() {
      super.configureServlets();

      bind(ErrorFilter.class).in(Scopes.SINGLETON);
      
      filter("/*").through(ErrorFilter.class);
      filter("/*").through(ObjectifyFilter.class);
      
      Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
      serviceClasses.add(UserEndpoint.class);
      serviceClasses.add(AntennaEndpoint.class);
      serviceClasses.add(DeviceEndpoint.class);
      serviceClasses.add(ItemEndpoint.class);
      serviceClasses.add(TrackPointEndpoint.class);
      serviceClasses.add(ConfigEndpoint.class);
      serviceClasses.add(AlertEndpoint.class);

      this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);

    }
  }
  
  /**
   * Servlets configuration. All the worker definitions must be configurated here.
   *
   */
  public static class WorkersServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
      bind(TrackPointWorker.class).in(Scopes.SINGLETON);
      serve(TrackPointWorker.WORKER_URL).with(TrackPointWorker.class);
    }
  }

  /**
   * Configure the guice binds for injections. Note: Is public, so it can be used by unit tests.
   */
  public static class MapsModule extends AbstractModule {

    @Override
    protected void configure() {

      requestStaticInjection(OfyService.class);

      // DAO Definitions
      bind(ObjectifyFilter.class).in(Singleton.class);
      bind(UserDao.class).to(UserOfyDao.class);
      bind(AntennaDao.class).to(AntennaOfyDao.class);
      bind(DeviceDao.class).to(DeviceOfyDao.class);
      bind(ItemDao.class).to(ItemOfyDao.class);
      bind(TrackPointDao.class).to(TrackPointOfyDao.class);
      bind(AlertDao.class).to(AlertOfyDao.class);

      // Service Definitions
      bind(UserService.class).to(UserServiceImpl.class);
      bind(AntennaService.class).to(AntennaServiceImpl.class);
      bind(ItemService.class).to(ItemServiceImpl.class);
      bind(DeviceService.class).to(DeviceServiceImpl.class);
      bind(TrackPointService.class).to(TrackPointServiceImpl.class);
      bind(TrackPointVisitor.class).to(TrackPointProcessorVisitor.class);
      
      bind(TrackPointPublisher.class).to(TrackPointPushPublisher.class);
      
      bind(FusionTablesService.class).to(FusionTablesServiceImpl.class);
      bind(HeatmapService.class).to(HeatMapServiceFusionTablesService.class);
      
      bind(AlertService.class).to(AlertServiceImpl.class);
    }

  }

  /**
   * Logs the time required to initialize guice framework.
   */
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {

    long time = System.currentTimeMillis();

    super.contextInitialized(servletContextEvent);

    long millis = System.currentTimeMillis() - time;

    log.info("Guice initialization took " + millis + " millis");
  }

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new MapsServletModule(), new MapsModule(),
        new WorkersServletModule());
  }

}
