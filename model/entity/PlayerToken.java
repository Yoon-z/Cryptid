package com.game.cryptid.model.entity;

/**
 * Abstract class used to store the cube and disc of the game.
 */
public abstract class PlayerToken {

  public static final String CUBE = "cube";
  public static final String DISC = "disc";
  private String name;
  private String color;

  public PlayerToken(String color) {
    this.color = color;
  }

  public Boolean meaning() {
    return false;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
