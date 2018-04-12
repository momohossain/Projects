package com.example.appl;

import java.util.Stack;
import java.util.logging.Logger;

import com.example.model.Idea;

public class IdeaCenter {
    private static final Logger LOG = Logger.getLogger(IdeaCenter.class.getName());

    private Stack<Idea> encyclopedia;
    private Stack<Idea> backwardEncyclopedia;

    public IdeaCenter(){
        encyclopedia= new Stack();
        backwardEncyclopedia= new Stack();
        LOG.fine("Idea center created added.");
    }

    public void PushIdea(String name, String description) {
        encyclopedia.push(new Idea(name,description));
        LOG.fine("Idea "+name+" added.");
    }

    public Stack<Idea> getEncyclopedia() {
        return encyclopedia;
    }

    public Idea getIdea(String name){
        Stack<Idea> temp = new Stack<>();
        Idea output = null;
        while(!encyclopedia.empty()) {
            if (encyclopedia.peek().getName().equals(name)) {
                output = encyclopedia.peek();
            } else temp.push(encyclopedia.pop());
        }
        while(!temp.empty()){
            encyclopedia.push(temp.pop());
        }
        return output;
    }

    public String getDescription(Idea idea){
        return idea.getDescription();
    }

    public Idea iterate(){
        if (!encyclopedia.empty()) {
            backwardEncyclopedia.push(encyclopedia.pop());
            return backwardEncyclopedia.peek();
        } else return null;
    }

    public void refreshEncyclopedia(){
        while (!backwardEncyclopedia.empty()) {
            encyclopedia.push(backwardEncyclopedia.pop());
        }
    }
}
