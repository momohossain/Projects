package com.example;

import java.io.InputStream;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.example.appl.IdeaCenter;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import com.example.ui.WebServer;

/**
 * The entry point for the Projects web application.
 *
 * @author Momo Hossain
 */
public final class Application {

  private static final Logger LOG = Logger.getLogger(Application.class.getName());

  /**
   * Entry point for the Guessing Game web application.
   *
   * It wires the application components together.
   *
   * @param args
   *    Command line arguments; none expected.
   */
  public static void main(String[] args) {
    // initialize Logging
    try {
      ClassLoader classLoader = Application.class.getClassLoader();
      final InputStream logConfig = classLoader.getResourceAsStream("log.properties");
      LogManager.getLogManager().readConfiguration(logConfig);
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Could not initialize log manager because: " + e.getMessage());
    }

    // create the one and only idea center
    final IdeaCenter ideaCenter = new IdeaCenter();

    // The application uses FreeMarker templates to generate the HTML
    // responses sent back to the client. This will be the engine processing
    // the templates and associated data.
    final TemplateEngine templateEngine = new FreeMarkerEngine();

    // inject the game center and freemarker engine into web server
    // This is an example of the Dependency inversion principle where the
    // IdeaCenter and WebServer dependencies are injected into the object.
    final WebServer webServer = new WebServer(templateEngine);

    // inject web server into application
    // This is an example of the Dependency inversion principle where the
    // WebServer dependency is injected into the object.
    final Application app = new Application(webServer);

    // start the application up
    app.initialize();
  }

  //
  // Attributes
  //

  private final WebServer webServer;

  //
  // Constructor
  //

  private Application(final WebServer webServer) {
    // validation
    Objects.requireNonNull(webServer, "webServer must not be null");
    //
    this.webServer = webServer;
  }

  //
  // Private methods
  //

  private void initialize() {
    LOG.config("Application is initializing.");

    // configure Spark and startup the Jetty web server
    webServer.initialize();

    // other applications might have additional services to configure

    LOG.config("Application initialization complete.");
  }

}
