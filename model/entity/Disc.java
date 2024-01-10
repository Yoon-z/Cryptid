package com.game.cryptid.model.entity;

/**
 * This class is used to store the disc of the game.
 * It contains the color of the disc.
 */
public class Disc extends PlayerToken {

  public Disc(String color) {
    super(color);
  }

  @Override
  public String getName() {
    return PlayerToken.DISC;
  }
}
