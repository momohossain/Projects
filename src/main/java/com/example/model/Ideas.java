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
}
