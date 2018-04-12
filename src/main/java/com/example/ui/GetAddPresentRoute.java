package com.example.ui;

import com.example.appl.IdeaCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.example.ui.UIStrings.*;
/**
 * The {@code GET /} route handler; aka the Home page.
 * This is the page where the user can see all the projects.
 *
 * @author Momo Hossain
 */
public class GetAddPresentRoute implements Route {

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
    GetAddPresentRoute(final TemplateEngine templateEngine) {
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
        Map<String, Object> vm = new HashMap<>();
        return templateEngine.render(new ModelAndView(vm,PRESENT_IDEA_ADDER_VIEW));
    }
}
