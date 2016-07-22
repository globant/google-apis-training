package com.globant.training.google.maps.configs;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;

import com.globant.training.google.maps.daos.AntennaDao;
import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.daos.objectify.AntennaOfyDao;
import com.globant.training.google.maps.daos.objectify.OfyService;
import com.globant.training.google.maps.daos.objectify.UserOfyDao;
import com.globant.training.google.maps.endpoints.AntennaEndpoint;
import com.globant.training.google.maps.endpoints.UserEndpoint;
import com.globant.training.google.maps.services.AntennaService;
import com.globant.training.google.maps.services.AntennaServiceImpl;
import com.globant.training.google.maps.services.UserService;
import com.globant.training.google.maps.services.UserServiceImpl;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.googlecode.objectify.ObjectifyFilter;


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

      filter("/*").through(ObjectifyFilter.class);

      Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
      serviceClasses.add(UserEndpoint.class);
      serviceClasses.add(AntennaEndpoint.class);
      
      this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
      
    }
  }

  /**
   * Configure the guice binds for injections.
   * Note: Is public, so it can be used by unit tests.
   */
  public static class MapsModule extends AbstractModule {

    @Override
    protected void configure() {

      requestStaticInjection(OfyService.class);

      //DAO Definitions
      bind(ObjectifyFilter.class).in(Singleton.class);
      bind(UserDao.class).to(UserOfyDao.class);
      bind(AntennaDao.class).to(AntennaOfyDao.class);
      
      //Service Definitions
      bind(UserService.class).annotatedWith(Names.named("userService")).to(UserServiceImpl.class);
      bind(AntennaService.class).to(AntennaServiceImpl.class);
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
    return Guice.createInjector(new MapsServletModule(), new MapsModule());
  }

}
