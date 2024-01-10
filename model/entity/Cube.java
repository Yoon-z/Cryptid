package com.game.cryptid.model.entity;

/**
 * This class is used to store the cube of the game.
 * It contains the color of the cube.
 */

public class Cube extends PlayerToken {

  public Cube(String color) {
    super(color);
  }

  @Override
  public String getName() {
    return PlayerToken.CUBE;
  }
}
