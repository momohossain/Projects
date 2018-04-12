package com.example.ui;

import java.util.Objects;
import java.util.logging.Logger;

import static com.example.ui.UIStrings.*;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import com.example.appl.IdeaCenter;
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

  IdeaCenter ideaCenter;

  private final TemplateEngine templateEngine;

  /**
   * The constructor for the Web Server.
   *
   * @param templateEngine
   *    The default {@link TemplateEngine} to render views.
   */
  public WebServer(final TemplateEngine templateEngine) {
    ideaCenter = new IdeaCenter();
    // validation
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
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

    get(HOME_URL, new GetHomeRoute(ideaCenter,templateEngine));

    get(PAST_IDEA_ADDER_URL,new GetAddPastRoute(templateEngine));

    get(PRESENT_IDEA_ADDER_URL, new GetAddPresentRoute(templateEngine));

    get(FUTURE_IDEA_ADDER_URL, new GetAddFutureRoute(templateEngine));

    post(HOME_URL, new PostAddPastRoute(ideaCenter, templateEngine));

    LOG.config("WebServer is initialized.");
  }

}
