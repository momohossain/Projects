package com.example.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Logger;

public class Ideas {
  private static final Logger LOG = Logger.getLogger(Ideas.class.getName());

  private Stack<Idea> encyclopedia= new Stack();

  public Ideas(String name, String description) {
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
}
