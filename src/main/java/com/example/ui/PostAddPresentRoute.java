package com.example.ui;

import com.example.appl.IdeaCenter;
import com.example.model.Idea;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.example.ui.UIStrings.HOME_VIEW;
import static com.example.ui.UIStrings.PAST_IDEA;
import static com.example.ui.UIStrings.PRESENT_IDEA;

/**
 * The {@code GET /} route handler; aka the Home page.
 * This is the page where the user can see all the projects.
 *
 * @author Momo Hossain
 */
public class PostAddPresentRoute implements Route {

    private IdeaCenter ideaCenter;

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
    PostAddPresentRoute(IdeaCenter ideaCenter, final TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.ideaCenter = ideaCenter;
        this.templateEngine = templateEngine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();

        String title = request.queryParams("title");
        String name = request.queryParams("name");
        String description = request.queryParams("description");

        ideaCenter.pushToPresent(title,name,description);

        vm.put(PRESENT_IDEA, new Idea(title,name,description));

        return templateEngine.render(new ModelAndView(vm, HOME_VIEW));
    }
}
