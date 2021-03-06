package com.example.appl;

import java.util.Stack;
import java.util.logging.Logger;

import com.example.model.Idea;

public class IdeaCenter {
    private static final Logger LOG = Logger.getLogger(IdeaCenter.class.getName());

    //I used a stack because I wanted the table to be in descending order of date added.
    // Couldn't figure out how to do that in the end so these stacks are basically pointless.
    private Stack<Idea> pastProjects;
    private Stack<Idea> presentProjects;
    private Stack<Idea> futureProjects;
    private Stack<Idea> backwardStack;

    public IdeaCenter(){
        pastProjects= new Stack();
        presentProjects = new Stack();
        futureProjects= new Stack();
        backwardStack= new Stack();
        LOG.fine("Idea center created.");
    }

    public void pushToPast(String title, String name, String description) {
        pastProjects.push(new Idea(title,name, description));
        LOG.fine("Past idea "+name+" added.");
/*
        System.out.println(pastProjects.peek());
*/
    }

    public void pushToPresent(String title, String name, String description) {
        presentProjects.push(new Idea(title,name, description));
        LOG.fine("Present idea "+name+" added.");
    }

    public void pushToFuture(String title, String name, String description) {
        futureProjects.push(new Idea(title,name, description));
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

    public Idea removeIdeaFromPast(String title){
        Idea output = null;
        while(!pastProjects.empty()) {
            if (pastProjects.peek().getName().equals(title)) {
                output = pastProjects.pop();
            } else backwardStack.push(pastProjects.pop());
        }
        refreshPastProjects();
        return output;
    }

    public Idea removeIdeaFromPresent(String title){
        Idea output = null;
        while(!presentProjects.empty()) {
            if (presentProjects.peek().getName().equals(title)) {
                output = presentProjects.pop();
            } else backwardStack.push(presentProjects.pop());
        }
        refreshPresentProjects();
        return output;
    }

    public Idea removeIdeaFromFuture(String title){
        Idea output = null;
        while(!futureProjects.empty()) {
            if (futureProjects.peek().getName().equals(title)) {
                output = futureProjects.pop();
            } else backwardStack.push(futureProjects.pop());
        }
        refreshFutureProjects();
        return output;
    }

    public String getTitle(Idea idea) {
        return idea.getTitle();
    }

    public String getName(Idea idea){
        return idea.getName();
    }

    public String getDescription(Idea idea){
        return idea.getDescription();
    }

    public Idea iteratePastProjects(){
        if (!pastProjects.empty()) {
            backwardStack.push(pastProjects.pop());
            return backwardStack.peek();
        } else return null;
    }

    public Idea iteratePresentProjects(){
        if (!presentProjects.empty()) {
            backwardStack.push(presentProjects.pop());
            return backwardStack.peek();
        } else return null;
    }

    public Idea iterateFutureProjects(){
        if (!futureProjects.empty()) {
            backwardStack.push(futureProjects.pop());
            return backwardStack.peek();
        } else return null;
    }

    public void refreshPastProjects(){
        while (!backwardStack.empty()) {
            pastProjects.push(backwardStack.pop());
        }
    }

    public void refreshPresentProjects(){
        while (!backwardStack.empty()) {
            presentProjects.push(backwardStack.pop());
        }
    }

    public void refreshFutureProjects(){
        while (!backwardStack.empty()) {
            futureProjects.push(backwardStack.pop());
        }
    }

    public boolean pastIsEmpty(){
        return (this.pastProjects.empty());
    }

    public boolean presentIsEmpty(){
        return (this.presentProjects.empty());
    }

    public boolean futureIsEmpty(){
        return (this.futureProjects.empty());
    }
}
