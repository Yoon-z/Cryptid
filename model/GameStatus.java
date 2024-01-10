package com.game.cryptid.model;

/**
 * This class is used to store the game status.
 * It contains the status of the game.
 */
public class GameStatus {
  private boolean initialSharing = false;
  private boolean ask = false;
  private boolean search = false;
  private boolean select = false;
  private boolean inGame = false;
  private boolean end = false;

  public void startGame(){ inGame = true; }

  public boolean getGameStatus(){ return inGame; }

  public boolean getInitialSharing() {
    return initialSharing;
  }

  public boolean getAsk() {
    return ask;
  }

  public void enableInitailSharing() {
    initialSharing = true;
  }

  public void disableInitailSharing() {
    initialSharing = false;
  }

  public void enableAsk() {
    ask = true;
  }

  public void disableAsk() {
    ask = false;
  }

  public boolean getSearch() {
    return search;
  }

  public void enableSearch() {
    search = true;
  }

  public void disableSearch() {
    search = false;
  }

  public boolean getSelect() {
    return select;
  }

  public void enableSelect() {
    select = true;
  }

  public void disableSelect() {
    select = false;
  }

  public boolean getEnd() {
    return end;
  }

  public void enableEnd() {
    select = end;
  }

}
