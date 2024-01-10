package com.game.cryptid.model.entity;

/**
 * Abstract class used to store the shack and stone of the game.
 */

public abstract class Structures {


  public static final String BLUE = "BLUE";
  public static final String WHITE = "WHITE";
  public static final String GREEN = "GREEN";
  private String color;

  public Structures() {
  }

  public Structures(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getName() {
    return "Structure";
  }
}
