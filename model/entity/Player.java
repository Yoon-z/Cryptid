package com.game.cryptid.model.entity;

/**
 * This class is used to store the player of the game.
 * It contains the name, the color and the player number.
 * It also contains the status of the player.
 * The status is used to check whether the player is in the round or not.
 */
public class Player {

  private final String name;
  private final String color;
  private final int playerNumber;
  private boolean status = false;
  public final static String yellow = "yellow";
  public final static String pink = "pink";
  public final static String green = "green";
  public final static String blue = "blue";
  public final static String purple = "purple";

  /**
   * This constructor is used to create a player.
   * It contains the name and the player number.
   * The player number is used to determine the color of the player.
   */
  public Player(String name, int playerNumber) {
    this.name = name;
    this.playerNumber = playerNumber;
    if (playerNumber == 1) {
      this.color = yellow;
    } else if (playerNumber == 2) {
      this.color = pink;
    } else if (playerNumber == 3) {
      this.color = green;
    } else if (playerNumber == 4) {
      this.color = blue;
    } else {
      this.color = purple;
    }
  }

  public void inRound() {
    this.status = true;
  }

  public void outRound() {
    this.status = false;
  }

  public boolean getStatus() {
    return status;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public int getPlayerNumber() {
    return playerNumber;
  }
}