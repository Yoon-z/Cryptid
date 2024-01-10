package com.game.cryptid.controller;

import com.game.cryptid.model.*;
import com.game.cryptid.model.entity.Answer;
import com.game.cryptid.model.entity.Hexagon;
import com.game.cryptid.model.entity.Player;
import com.game.cryptid.view.ClueView;
import com.game.cryptid.view.StartView;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller of the game.
 */
public class Controller {

  private static MapModel mapModel;
  private static AnswerModel answerModel;
  private static MarkAction markAction;
  private static SetStatus setStatus;
  private static List<Hexagon> mapList;
  private static Answer answer;
  private static List<Player> playerList;
  private static GameStatus gameStatus;
  private static ClueView clueView;

  public static void main(String[] args) {
    StartView startView = new StartView();
    startView.setVisible(true);
  }

  /**
   * Constructor of Controller.
   */
  public Controller() {
    this.answerModel = new AnswerModel();
    this.mapModel = new MapModel();
    this.answer = new Answer();
    this.markAction = new MarkAction();
    this.setStatus = new SetStatus();
    this.playerList = new ArrayList<Player>();
    this.gameStatus = new GameStatus();
    this.mapList = new ArrayList<Hexagon>();
    setMap();
  }

  public String getName(){
    return "controller";
  }

  /** click to start game, then init the map. */
  public static void setMap() {
    mapList =  mapModel.getMapList();
  }

  public List<Hexagon> getMap() {
    return mapList;
  }

  public void setClueView(ClueView clueView){
    this.clueView = clueView;
  }

  public ClueView getClueView(){
    return this.clueView;
  }

  /** get the cryptid, which with the information of position of cryptid
   * and a list of hinweise of cryptid. */
  public void setAnswer(int numPlayer) {
    answer = answerModel.getAnswer(numPlayer);
  }

  public Answer getAnswer() {
    return answer;
  }

  public void addPlayer(Player player) {
    playerList.add(player);
  }

  public List<Player> getPlayerList() {
    return playerList;
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  /** add a cube in playerTokenList of hexagon, and the color of cube is same with player. */
  public boolean markAsCube(Hexagon hexagon, Player player) {
    return markAction.markAsCube(hexagon, player);
  }

  /** add a disc in playerTokenList of hexagon, and the color of cube is same with player. */
  public boolean markAsDisc(Hexagon hexagon, Player player) {
    return markAction.markAsDisc(hexagon, player);
  }

  /** If the selected hexagon with three true mark and same with cryptid,
   * return true, otherwise return false. */
  public boolean gameWon(Hexagon hexagon) {
    return setStatus.gameWon(hexagon, answer);
  }

  public boolean hasCube(Hexagon hexagon) {
    return MarkAction.hasCube(hexagon);
  }

}
