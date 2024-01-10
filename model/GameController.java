package com.game.cryptid.model;

import com.game.cryptid.model.GameClientModel;

/**
 * TODO: To be implemented by other team members.
 * The controller class for the client side of the game.
 */
public class GameController {
  /** the model of the game client. */
  private final GameClientModel model;

  /**
   * Class constructor that create new instance of controller.
   *
   * @param model reference to the game client model class {@link GameClientModel}
   */
  public GameController(GameClientModel model) {
    this.model = model;
  }

}
