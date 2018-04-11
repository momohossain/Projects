package com.example.ui;

import static spark.Spark.halt;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import spark.TemplateEngine;

/**
 * The {@code GET /} route handler; aka the Home page.
 * This is the page where the user starts (no Game yet)
 * but is also the landing page after a game ends.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author <a href='mailto:jrv@se.rit.edu'>Jim Vallino</a>
 */
public class GetHomeRoute implements Route {

  // Values used in the view-model map for rendering the home view.
  static final String TITLE_ATTR = "title";
  static final String NEW_PLAYER_ATTR = "newPlayer";
  static final String TITLE = "Welcome to the Guessing Game";
  static final String VIEW_NAME = "home.ftl";

  // Key in the session attribute map for the player who started the session
  static final String PLAYERSERVICES_KEY = "playerServices";


  //
  // Attributes
  //

  private final TemplateEngine templateEngine;

  //
  // Constructor
  //

  /**
   * The constructor for the {@code POST /guess} route handler.
   *
   * @param templateEngine
   *    The {@link TemplateEngine} for the application to use when rendering HTML responses.
   *
   * @throws NullPointerException
   *    when the {@code gameCenter} or {@code templateEngine} parameter is null
   */
  GetHomeRoute(final TemplateEngine templateEngine) {
    // validation
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    //
    this.templateEngine = templateEngine;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String handle(Request request, Response response) {
    // retrieve the HTTP session
    final Session httpSession = request.session();

    // start building the View-Model
    final Map<String, Object> vm = new HashMap<>();
    vm.put(TITLE_ATTR, TITLE);

    // if this is a brand new browser session or a session that timed out
    if(httpSession.attribute(PLAYERSERVICES_KEY) == null) {
      // get the object that will provide client-specific services for this player

      // render the Game Form view
      vm.put(NEW_PLAYER_ATTR, true);
      return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
    else {
      // there is a game already being played so redirect the user to the Game view
      halt();
      return null;
    }
  }
}
