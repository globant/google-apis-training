package com.globant.training.google.maps.configs;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;

import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.daos.objectify.OfyService;
import com.globant.training.google.maps.endpoints.UserEndpoint;
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
 * 
 * GuiceServletContextListener for configuring guice.
 * 
 * @author gabriel.sideri
 *
 */
public class GuiceConfig extends GuiceServletContextListener {

  private static final Logger log = Logger.getLogger(GuiceConfig.class.getName());
  
  /**
   * Servlet configuration. 
   *
   */
  static class MapsServletModule extends GuiceSystemServiceServletModule {

    
    @Override
    protected void configureServlets() {
      super.configureServlets();

      filter("/*").through(ObjectifyFilter.class);

      Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
      serviceClasses.add(UserEndpoint.class);

      this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);

      
    }
  }

  /** 
   * Configure the guice binds for injections.
   * 
   * Note: Is public, so it can be used by unit tests.
   */
  public static class MapsModule extends AbstractModule {

    @Override
    protected void configure() {
      
      requestStaticInjection(OfyService.class);

      bind(ObjectifyFilter.class).in(Singleton.class);
      bind(UserDao.class);
      bind(UserService.class).annotatedWith(Names.named("userService")).to(UserServiceImpl.class);
    }
  }

  /**
   * Logs the time required to initialize Guice
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
