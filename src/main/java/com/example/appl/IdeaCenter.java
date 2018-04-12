package com.example.appl;

import java.util.Stack;
import java.util.logging.Logger;

import com.example.model.Idea;

public class IdeaCenter {
    private static final Logger LOG = Logger.getLogger(IdeaCenter.class.getName());

    private Stack<Idea> pastProjects;
    private Stack<Idea> presentProjects;
    private Stack<Idea> futureProjects;
    private Stack<Idea> backwardStack;

    public IdeaCenter(){
        pastProjects= new Stack();
        presentProjects = new Stack();
        futureProjects= new Stack();
        backwardStack= new Stack();
        LOG.fine("Idea center created added.");
    }

    public void pushToPast(String name, String description) {
        pastProjects.push(new Idea(name,description));
        LOG.fine("Past idea "+name+" added.");
    }

    public void pushToPresent(String name, String description) {
        presentProjects.push(new Idea(name,description));
        LOG.fine("Present idea "+name+" added.");
    }

    public void pushToFuture(String name, String description) {
        futureProjects.push(new Idea(name,description));
        LOG.fine("Future idea "+name+" added.");
    }

    public void pushToPast(Idea idea) {
        pastProjects.push(idea);
        LOG.fine("Past idea "+idea.getName()+" added.");
    }

    public void pushToPresent(Idea idea) {
        presentProjects.push(idea);
        LOG.fine("Present idea "+idea.getName()+" added.");
    }

    public void pushToFuture(Idea idea) {
        futureProjects.push(idea);
        LOG.fine("Future idea "+idea.getName()+" added.");
    }

    public Stack<Idea> getPastProjects() {
        return pastProjects;
    }

    public Stack<Idea> getPresentProjects() {
        return presentProjects;
    }

    public Stack<Idea> getFutureProjects() {
        return futureProjects;
    }

    public Idea removeIdeaFromPast(String name){
        Idea output = null;
        while(!pastProjects.empty()) {
            if (pastProjects.peek().getName().equals(name)) {
                output = pastProjects.pop();
            } else backwardStack.push(pastProjects.pop());
        }
        refreshEncyclopedia();
        return output;
    }

    public Idea removeIdeaFromPresent(String name){
        Idea output = null;
        while(!presentProjects.empty()) {
            if (presentProjects.peek().getName().equals(name)) {
                output = presentProjects.pop();
            } else backwardStack.push(presentProjects.pop());
        }
        refreshEncyclopedia();
        return output;
    }

    public Idea removeIdeaFromFuture(String name){
        Idea output = null;
        while(!futureProjects.empty()) {
            if (futureProjects.peek().getName().equals(name)) {
                output = futureProjects.pop();
            } else backwardStack.push(futureProjects.pop());
        }
        refreshEncyclopedia();
        return output;
    }

    public String getDescription(Idea idea){
        return idea.getDescription();
    }

    public Idea iterate(){
        if (!pastProjects.empty()) {
            backwardStack.push(pastProjects.pop());
            return backwardStack.peek();
        } else return null;
    }

    public void refreshEncyclopedia(){
        while (!backwardStack.empty()) {
            pastProjects.push(backwardStack.pop());
        }
    }
}
