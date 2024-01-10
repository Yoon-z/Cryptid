package com.game.cryptid.model;

import com.game.cryptid.model.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to store the mark action of the game.
 * It contains the list of cubes and discs.
 */
public class MarkAction {
  private final List<Hexagon> cubes = new ArrayList<Hexagon>(); //List of cubes
  private final List<Hexagon> discs = new ArrayList<Hexagon>(); //List of discs

  /**
   * Check if the hexagon has been marked as cube.
   */
  public static boolean hasCube(Hexagon hexagon) {
    List<PlayerToken> playerTokenList = hexagon.getPlayerTokens();
    for (PlayerToken playerToken : playerTokenList) {
      if (Objects.equals(playerToken.getName(), "cube")) {
        return true;
      }
    }
    return false;
  }

  /**
   * Mark the hexagon as cube. If the hexagon has already been marked as cube, return false.
   * Otherwise, add the cube to the hexagon and return true.
   */
  public boolean markAsCube(Hexagon hexagon, Player player) {
    List<PlayerToken> playerTokens = hexagon.getPlayerTokens();
    for (PlayerToken playerToken : playerTokens) {
      if (Objects.equals(playerToken.getColor(), player.getColor())) {
        return false;
      }
    }
    hexagon.setPlayerToken(new Cube(player.getColor()));
    cubes.add(hexagon);
    return true;
  }

  /**
   * Mark the hexagon as disc. If the hexagon has already been marked as disc, return false.
   * Otherwise, add the disc to the hexagon and return true.
   */
  public boolean markAsDisc(Hexagon hexagon, Player player) {
    List<PlayerToken> playerTokens = hexagon.getPlayerTokens();
    for (PlayerToken playerToken : playerTokens) {
      if (Objects.equals(playerToken.getColor(), player.getColor())) {
        return false;
      }
    }
    hexagon.setPlayerToken(new Disc(player.getColor()));
    cubes.add(hexagon);
    return true;
  }
}
