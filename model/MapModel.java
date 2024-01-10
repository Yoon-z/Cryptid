package com.game.cryptid.model;

import com.game.cryptid.model.entity.*;
import java.util.List;

/**
 * Initialise the map.
 */
public class MapModel {

  List<Hexagon> mapList;

  /**
   * Constructor of MapModel.
   */
  public MapModel() {
    mapList = List.of(
            //first row
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.BEAR_TERRITORY, 1, 1),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.BEAR_TERRITORY, 1, 2),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 1, 3),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.COUGAR_TERRITORY, 1, 4),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.COUGAR_TERRITORY, 1, 5),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 1, 6)
                   .setStructures(new Shack(Structures.BLUE)),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.BEAR_TERRITORY, 1, 7),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 1, 8),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 1, 9),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.COUGAR_TERRITORY, 1, 10),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 1, 11),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 1, 12),

            //second row
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 2, 1),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 2, 2),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 2, 3),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 2, 4),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 2, 5),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 2, 6),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 2, 7),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 2, 8),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 2, 9)
                   .setStructures(new Shack(Structures.WHITE)),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 2, 10),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 2, 11),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 2, 12),

            //third row
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 3, 1),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 3, 2),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 3, 3),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 3, 4),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 3, 5),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 3, 6),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 3, 7),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 3, 8),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 3, 9),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 3, 10),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 3, 11),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 3, 12),

            //fourth row
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 4, 1),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 4, 2),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 4, 3),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.BEAR_TERRITORY, 4, 4),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 4, 5),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 4, 6),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 4, 7),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 4, 8),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.COUGAR_TERRITORY, 4, 9),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.BEAR_TERRITORY, 4, 10),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 4, 11),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 4, 12),

            //fifth row
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 5, 1),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 5, 2),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.COUGAR_TERRITORY, 5, 3),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.BEAR_TERRITORY, 5, 4),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 5, 5),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 5, 6),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 5, 7),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 5, 8),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.COUGAR_TERRITORY, 5, 9),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 5, 10),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 5, 11),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 5, 12),

            //sixth row
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 6, 1),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 6, 2)
                   .setStructures(new Stone(Structures.GREEN)),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 6, 3),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 6, 4),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 6, 5),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 6, 6),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 6, 7),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 6, 8),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 6, 9),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 6, 10),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 6, 11),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 6, 12),

            //seventh row
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 7, 1),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 7, 2),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 7, 3),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 7, 4),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 7, 5),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 7, 6)
                   .setStructures(new Shack(Structures.GREEN)),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 7, 7),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 7, 8),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 7, 9),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 7, 10),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 7, 11),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 7, 12),

            //eighth row
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 8, 1),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 8, 2),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 8, 3),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 8, 4),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 8, 5),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.NONE_TERRITORY, 8, 6),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 8, 7)
                   .setStructures(new Stone(Structures.WHITE)),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.NONE_TERRITORY, 8, 8),
            Hexagon.create(Hexagon.WATER_TERRAIN, Hexagon.COUGAR_TERRITORY, 8, 9),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 8, 10),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 8, 11),
            Hexagon.create(Hexagon.MOUNTAIN_TERRAIN, Hexagon.BEAR_TERRITORY, 8, 12),

            //ninth row
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 9, 1),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 9, 2),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 9, 3),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 9, 4),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 9, 5),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 9, 6),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.NONE_TERRITORY, 9, 7),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.NONE_TERRITORY, 9, 8)
                   .setStructures(new Stone(Structures.BLUE)),
            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.COUGAR_TERRITORY, 9, 9),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 9, 10),
            Hexagon.create(Hexagon.SWAMP_TERRAIN, Hexagon.NONE_TERRITORY, 9, 11),
            Hexagon.create(Hexagon.DESERT_TERRAIN, Hexagon.BEAR_TERRITORY, 9, 12)
    );
  }

  public List<Hexagon> getMapList() {
    return mapList;
  }

  public void setMapList(List<Hexagon> mapList) {
    this.mapList = mapList;
  }
}
