package com.game.cryptid.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store the hexagon of the game.
 * It contains the terrain, the territory, the x and y coordinates,
 * the mysterious creature, the player tokens and the structures.
 * It is used to build the map of the game.
 */
public class Hexagon {

  public static final String COUGAR_TERRITORY = "cougar";
  public static final String BEAR_TERRITORY = "bear";
  public static final String NONE_TERRITORY = "none";

  public static final String SWAMP_TERRAIN = "swamp";

  public static final String WATER_TERRAIN = "water";

  public static final String DESERT_TERRAIN = "desert";

  public static final String FOREST_TERRAIN = "forest";

  public static final String MOUNTAIN_TERRAIN = "mountain";



  private String terrain;


  private String territory = NONE_TERRITORY;

  private Integer x_coordinate;


  private Integer y_coordinate;


  private Boolean mysteriousCreature = false;


  private List<PlayerToken> playerTokens = new ArrayList<>();


  private List<Structures> structuresList = new ArrayList<>();

  /**
   * This method is used to create a hexagon with the terrain,
   * the territory, the x and y coordinates.
   */
  public Hexagon(String terrain, String territory, Integer x_coordinate, Integer y_coordinate) {
    this.terrain = terrain;
    this.territory = territory;
    this.x_coordinate = x_coordinate;
    this.y_coordinate = y_coordinate;
  }

  public static Hexagon createDefault(String terrain, Integer x_coordinate, Integer y_coordinate) {
    return new Hexagon(terrain, NONE_TERRITORY, x_coordinate, y_coordinate);
  }

  public static Hexagon create(String terrain, Integer x_coordinate, Integer y_coordinate) {
    return new Hexagon(terrain, NONE_TERRITORY, x_coordinate, y_coordinate);
  }

  public static Hexagon create(String terrain, String territory,
                               Integer x_coordinate, Integer y_coordinate) {
    return new Hexagon(terrain, territory, x_coordinate, y_coordinate);
  }

  public String getTerrain() {
    return terrain;
  }

  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }


  public String getTerritory() {
    return territory;
  }

  public void setTerritory(String territory) {
    this.territory = territory;
  }

  public Integer getX_coordinate() {
    return x_coordinate;
  }

  public void setX_coordinate(Integer x_coordinate) {
    this.x_coordinate = x_coordinate;
  }

  public Integer getY_coordinate() {
    return y_coordinate;
  }

  public void setY_coordinate(Integer y_coordinate) {
    this.y_coordinate = y_coordinate;
  }

  public List<PlayerToken> getPlayerTokens() {
    return playerTokens;
  }

  public void setPlayerTokens(List<PlayerToken> playerTokens) {
    this.playerTokens = playerTokens;
  }

  /**
   * Add a player token to the hexagon.
   */
  public void setPlayerToken(PlayerToken e) {
    playerTokens.add(e);
  }

  public Boolean getMysteriousCreature() {
    return mysteriousCreature;
  }

  public Hexagon setMysteriousCreature(Boolean mysteriousCreature) {
    this.mysteriousCreature = mysteriousCreature;
    return this;
  }

  public List<Structures> getStructuresList() {
    return structuresList;
  }

  public void setStructuresList(List<Structures> structuresList) {
    this.structuresList = structuresList;
  }

  /**
   * Add a structure to the hexagon.
   */
  public Hexagon setStructures(Structures e) {
    structuresList.add(e);
    return this;
  }
}
