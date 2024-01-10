package com.game.cryptid.model;

import com.game.cryptid.model.entity.Answer;
import com.game.cryptid.model.entity.Clue;
import com.game.cryptid.model.entity.Hexagon;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This class is used to store the answer of the game.
 */
public class AnswerModel {
  Map<Integer, List<Answer>> answerMap = new HashMap<>();
  /**
   * This method is used to get the answer of the game.
   */

  public AnswerModel() {
    List<Answer> three = List.of(

            Answer.create(3,
                            Hexagon.createDefault(Hexagon.SWAMP_TERRAIN, 8, 5).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within three spaces of a green structure"))
                    .setClue(Clue.create(2, "The habitat is within two spaces of a shack"))
                    .setClue(Clue.create(3, "The habitat is within one space of forest")),

            Answer.create(3,
                            Hexagon.createDefault(Hexagon.WATER_TERRAIN, 7, 10).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within one space of forest"))
                    .setClue(Clue.create(2, "The habitat is on water or desert"))
                    .setClue(Clue.create(3, "The habitat is within one spaces of a swamp")),
            Answer.create(3,
                            Hexagon.createDefault(Hexagon.WATER_TERRAIN, 5, 5).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within one space of either animal territory"))
                    .setClue(Clue.create(2, "The habitat is within one space of desert"))
                    .setClue(Clue.create(3, "The habitat is on water or swamp"))
    );

    List<Answer> four = List.of(

            Answer.create(4,
                            Hexagon.createDefault(Hexagon.WATER_TERRAIN, 3, 2).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within three spaces of a white structure"))
                    .setClue(Clue.create(2, "The habitat is within two spaces of bear territory"))
                    .setClue(Clue.create(3, "The habitat is within one space of forest"))
                    .setClue(Clue.create(4, "The habitat is on water or forest")),

            Answer.create(4,
                            Hexagon.createDefault(Hexagon.WATER_TERRAIN, 2, 8).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is on water"))
                    .setClue(Clue.create(2, "The habitat is within one space of desert"))
                    .setClue(Clue.create(3, "The habitat is on water or swamp"))
                    .setClue(Clue.create(4, "The habitat is within two spaces of a shack")),

            Answer.create(4,
                            Hexagon.createDefault(Hexagon.WATER_TERRAIN, 8, 8).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within one space of desert"))
                    .setClue(Clue.create(2, "The habitat is within two spaces of a cougar territory"))
                    .setClue(Clue.create(3, "The habitat is on water or mountain"))
                    .setClue(Clue.create(4, "The habitat is on water or desert"))
    );

    List<Answer> five = List.of(

            Answer.create(5,
                            Hexagon.createDefault(Hexagon.DESERT_TERRAIN, 9, 6).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within one space of either animal territory"))
                    .setClue(Clue.create(2, "The habitat is on forest or desert"))
                    .setClue(Clue.create(3, "The habitat is within one space of swamp"))
                    .setClue(Clue.create(4, "The habitat is on desert or swamp"))
                    .setClue(Clue.create(5, "The habitat is within three spaces of a green structure")),

            Answer.create(5,
                            Hexagon.createDefault(Hexagon.WATER_TERRAIN, 8, 3).setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is on water or desert"))
                    .setClue(Clue.create(2, "The habitat is within one space of either animal territory"))
                    .setClue(Clue.create(3, "The habitat is within three spaces of a white structure"))
                    .setClue(Clue.create(4, "The habitat is within one space of forest"))
                    .setClue(Clue.create(5, "The habitat is on water or mountain")),

            Answer.create(5,
                            Hexagon.create(Hexagon.FOREST_TERRAIN, Hexagon.COUGAR_TERRITORY, 2, 5)
                                    .setMysteriousCreature(true))
                    .setClue(Clue.create(1, "The habitat is within one space of desert"))
                    .setClue(Clue.create(2, "The habitat is on forest or mountain"))
                    .setClue(Clue.create(3, "The habitat is within one space of swamp"))
                    .setClue(Clue.create(4, "The habitat is within one space of a cougar territory"))
                    .setClue(Clue.create(5, "The habitat is within two spaces of a shack"))
    );
    answerMap.put(3, three);
    answerMap.put(4, four);
    answerMap.put(5, five);
  }

  public Answer getAnswer(Integer players) {
    Random random = new Random();
    return answerMap.get(players).get(random.nextInt(3));
  }
}
