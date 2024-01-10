package com.game.cryptid.controller;

import com.game.cryptid.images.PlayerTokenLabel;
import com.game.cryptid.model.entity.Player;
import com.game.cryptid.view.*;

import javax.swing.*;
import java.util.Objects;

public class ControllerNetwork extends Controller{

    private static SelectNumberView selectNumberView;
    private static ClueViewNetwork clueViewNetwork;

    private static GameBoardViewNetwork gameBoardViewNetwork;

    private ControllerNetwork controller;

    private static int selectedNum;

    private static Player player;

    private static WaitView waitView;

    public ControllerNetwork(){
        super();
    }

    @Override
    public String getName(){
        return "network controller";
    }

    public ControllerNetwork getController(){
        return controller;
    }

    @Override
    public void addPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    /**
     * when player select network mode, client send new player to server.
     * If this is the first user, then server send message back to open SelectNumberView. */
    public void logIn(ControllerNetwork controller){
        this.controller = controller;
    }

    /** get message from client to open SelectNumberView */
    public void openSelectNumberView(){
        selectNumberView = new SelectNumberView(controller);
        selectNumberView.setVisible(true);
    }

    /** if this player is not the first one to log in, then server send message to client to open WaitView. */
    public void openWaitView(){
        waitView = new WaitView();
        waitView.setVisible(true);
    }

    /** send the number of player to the server. */
    public static void sendSelectedNumber(int num){
        selectedNum = num;
    }

    /** when the loggedIN number == selectNum,
     *  server send message to client to open the ClueView,
     *  to close the WaitView for waiting players */
    public void openClueView(){
        waitView.setVisible(false);

        clueViewNetwork = new ClueViewNetwork(controller);
        clueViewNetwork.setVisible(true);
    }

    /** send message to server that player has checked clue. */
    public void sendCheckedClueConfirm(){
        // TODO
    }

    /** when checkedClueNum == selectedNum, open the GameBoardViewNetwork. */
    public void openGameBoardViewNetwork(){
        gameBoardViewNetwork = new GameBoardViewNetwork(selectedNum, controller);
        gameBoardViewNetwork.setVisible(true);
    }

    /** the player start to share initial information. */
    public void startInitialSharing(){
        getPlayer().inRound();
        getGameStatus().enableInitailSharing();
        gameBoardViewNetwork.getStatus().setText("initial sharing...");
    }

    /** update view to mark Hexagon */
    public void markHexagon(int index, String token){
        if(Objects.equals(token, "cube")) {
            JLabel cube = new PlayerTokenLabel("cube", getPlayer().getColor());
            gameBoardViewNetwork.getButtonPanels().get(index).add(cube);
            gameBoardViewNetwork.getMapUnits().get(index).add(gameBoardViewNetwork.getButtonPanels().get(index));

            //TODO: start select phase

        } else if(Objects.equals(token, "disc")) {
            JLabel disc = new PlayerTokenLabel("disc", getPlayer().getColor());
            gameBoardViewNetwork.getButtonPanels().get(index).add(disc);
            gameBoardViewNetwork.getMapUnits().get(index).add(gameBoardViewNetwork.getButtonPanels().get(index));
        }
    }

    /** when player finish the initial sharing, send message to server, which hexagon is selected */
    public void sendFinishedInitialSharing(int index){
        // TODO
    }

    /** when player end the initial sharing phase, send message to server */
    public void sendEndInitialSharing(){
        // TODO
    }

    /** player start to choose to ask or search */
    public void askOrSearch(){
        gameBoardViewNetwork.doAskOrSearch(getController(), getPlayer());
        getPlayer().inRound();
    }

    /** send message to server, which player to ask and index of map button */
    public void sendAsk(Player selectedPlayer, int index){
        // TODO
    }

    /**
     * server send message to selected player,
     * player start to answer, if this hexagon can be cryptid or not
     * and send the answer to server */
    public void answerAsk(int index){
        gameBoardViewNetwork.getStatus().setText("answering...");
        String token = gameBoardViewNetwork.doMarkHexagon(getMap().get(index), getPlayer(), getController());
        // TODO: validation, if the player give the wrong answer, then need to doMarkHexagon again (Ming Yuan's task)
        gameBoardViewNetwork.getStatus().setText("waiting...");

        // TODO: send answer to server
    }

    /** send message to server, search the hexagon with index */
    public void sendSearch(int index){
        // TODO
    }

    /**
     * if the searched hexagon is cryptid, then the player win the game
     * server send message to client to showWinner
     * */
    public void showWinner(Player player){
        gameBoardViewNetwork.showWinner(player);
    }

    /**
     * when the another player answer with cube in asking phase or
     * in searching phase,
     * then server send message to client to start select a hexagon */
    public void startSelect(){
        getGameStatus().enableSelect();
    }

    /** send message to server, which hexagon is selected */
    public void sendSelect(int index){
        // TODO
    }

    /** if one player has restarted the game, then send message to server to restart game for all players */
    public void sendRestart(){
        // TODO
    }

    /** if one player has ended the game, then send message to server to end game for all players */
    public void sendEndGame() {
        // TODO
    }

    /** server send message to client to restart the game */
    public void restart(){
        new StartView().setVisible(true);
        gameBoardViewNetwork.setVisible(false);
        gameBoardViewNetwork.dispose();
    }

    /** server send message to client to end the game */
    public void endgame(){
        gameBoardViewNetwork.reveal((controller.getAnswer().getHexagon().getX_coordinate()-1)*12 + (controller.getAnswer().getHexagon().getY_coordinate()-1));
        gameBoardViewNetwork.getStatus().setText("end game");

        //disable buttons
        getGameStatus().disableInitailSharing();
        getGameStatus().disableAsk();
        getGameStatus().disableSearch();
        getGameStatus().disableSelect();
    }
}
