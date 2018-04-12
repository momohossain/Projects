package com.example.ui;

import static com.example.ui.UIStrings.HOME_VIEW;
import static spark.Spark.halt;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

import com.example.appl.IdeaCenter;
import com.example.model.Idea;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import spark.TemplateEngine;

/**
 * The {@code GET /} route handler; aka the Home page.
 * This is the page where the user can see all the projects.
 *
 * @author Momo Hossain
 */
public class GetHomeRoute implements Route {

  IdeaCenter ideacenter;

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
  GetHomeRoute(IdeaCenter ideacenter, final TemplateEngine templateEngine) {
    // validation
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    //
    this.ideacenter = ideacenter;
    this.templateEngine = templateEngine;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String handle(Request request, Response response) {
    final Map<String, Object> vm = new HashMap<>();
    Stack<Idea> pastProjects = this.ideacenter.getPastProjects();
    Stack<Idea> presentProjects = this.ideacenter.getPresentProjects();
    Stack<Idea> futureProjects = this.ideacenter.getFutureProjects();



    return templateEngine.render(new ModelAndView(vm, HOME_VIEW));
  }
}
