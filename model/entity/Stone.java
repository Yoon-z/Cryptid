package com.game.cryptid.model.entity;

/**
 * This class is used to store the stone of the game.
 * It contains the color of the stone.
 */
public class Stone extends Structures {

  public Stone() {
  }

  public Stone(String color) {
    super(color);
  }

  public String getName() {
    return "Stone";
  }

}
