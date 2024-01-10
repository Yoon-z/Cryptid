package com.game.cryptid.model;

import com.game.cryptid.model.entity.Clue;

/**
 * This class is used to store the user of the game.
 * It contains the name of the user and the clue of the user.
 */
public class UserModel {

  private String name;
  private Clue clue;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Clue getClue() {
    return clue;
  }

  public void setClue(Clue clue) {
    this.clue = clue;
  }
}
