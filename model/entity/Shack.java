package com.game.cryptid.model.entity;

/**
 * This class is used to store the shack of the game.
 * It contains the color of the shack.
 */
public class Shack extends Structures {

  public Shack() {
  }

  public Shack(String color) {
    super(color);
  }

  public String getName() {
    return "Shack";
  }

}
