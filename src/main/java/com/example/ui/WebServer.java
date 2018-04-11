package com.example.ui;

import java.util.Objects;
import java.util.logging.Logger;

import static com.example.ui.UIStrings.HOME_URL;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import com.example.appl.IdeasModder;
import spark.TemplateEngine;

/**
 * The server that initializes the set of HTTP request handlers.
 * This defines the <em>web application interface</em> for this
 * guessing game application.
 *
 * @author Momo Hossain
 */
public class WebServer {
  private static final Logger LOG = Logger.getLogger(WebServer.class.getName());

  private final TemplateEngine templateEngine;

  /**
   * The constructor for the Web Server.
   *
   * @param ideasModder
   *    The {@link IdeasModder} for the application.
   * @param templateEngine
   *    The default {@link TemplateEngine} to render views.
   */
  public WebServer(
      final IdeasModder ideasModder,
      final TemplateEngine templateEngine) {
    // validation
    Objects.requireNonNull(ideasModder, "ideasModder must not be null");
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    //
    this.templateEngine = templateEngine;
  }

  //
  // Public methods
  //

  /**
   * Initialize all of the HTTP routes that make up this web application.
   *
   * Initialization of the web server includes defining the location for static
   * files, and defining all routes for processing client requests. The method
   * returns after the web server finishes its initialization.
   */
  public void initialize() {
    // Configuration to serve static files
    staticFiles.location("/public");

    get(HOME_URL, new GetHomeRoute(templateEngine));


    LOG.config("WebServer is initialized.");
  }

}
