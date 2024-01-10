package com.game.cryptid.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is used to store the answer of the game.
 * It contains the number of players, the hexagon and the clues.
 */
public class Answer {
  private Integer players;

  private List<Clue> clueList = new ArrayList<>();

  private Hexagon hexagon;

  public Answer() {
  }

  public Answer(Integer players, Hexagon hexagon) {
    this.players = players;
    this.hexagon = hexagon;
  }

  public static Answer create(Integer players, Hexagon hexagon) {
    return new Answer(players, hexagon);
  }

  public Integer getPlayers() {
    return players;
  }

  public Answer setPlayers(Integer players) {
    this.players = players;
    return this;
  }

  public List<Clue> getClueList() {
    return clueList;
  }

  public Answer setClueList(List<Clue> clueList) {
    this.clueList = clueList;
    return this;
  }

  public Hexagon getHexagon() {
    return hexagon;
  }

  public Answer setHexagon(Hexagon hexagon) {
    this.hexagon = hexagon;
    return this;
  }

  public Clue getRandomClue() {
    Random random = new Random();
    return clueList.get(random.nextInt(3) - 1);
  }

  public Answer setClue(Clue clue) {
    clueList.add(clue);
    return this;
  }
}
