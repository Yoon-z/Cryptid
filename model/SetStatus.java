package com.game.cryptid.model;

import com.game.cryptid.model.entity.Answer;
import com.game.cryptid.model.entity.Hexagon;
import java.util.Objects;

/**
 * This class is used to set the status of the game.
 * It contains the method to check if the game is won.
 */
public class SetStatus {
  /**
   * This method is used to check if the game is won.
   */
  public boolean gameWon(Hexagon hexagon, Answer answer) {
    return Objects.equals(hexagon.getX_coordinate(), answer.getHexagon().getX_coordinate()) && Objects.equals(hexagon.getY_coordinate(), answer.getHexagon().getY_coordinate());
  }
}

