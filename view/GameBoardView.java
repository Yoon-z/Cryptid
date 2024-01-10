package com.game.cryptid.view;

import com.game.cryptid.controller.Controller;
import com.game.cryptid.images.PlayerTokenLabel;
import com.game.cryptid.images.StructureLabel;
import com.game.cryptid.model.MapModel;
import com.game.cryptid.model.entity.Hexagon;
import com.game.cryptid.model.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class design and implement the game board screen of the
 * game where player interact with the other players and the map.
 */
public class GameBoardView extends JFrame {

  /** number of player in the game. */
  private final int numOfPlayer;

  /** TODO: reference to map model class. */
  private MapModel mapModel;

  private final JFrame thisFrame;
  
  private static int numInitialSharing;
  private static Player playerSelected;
  private static List<JLabel> playerStatus;
  private static List<HexButton> mapUnits;


  /**
   * Constructor that creates a new instance of the class {@link GameBoardView}.
   *
   * @param number the number of player in the game
   * @param controller reference to the game controller class {@link Controller}
   * @throws HeadlessException if target machine does not support keyboard
   */
  public GameBoardView(int number, Controller controller) throws HeadlessException {

    super();
    this.thisFrame = this;
    this.numOfPlayer = number;
    this.setTitle("Game Board");
    this.setSize(new Dimension(1600, 1000));
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.setBackground(Color.GRAY);
    this.mapModel = new MapModel();
    this.playerStatus = new ArrayList<JLabel>();
    this.numInitialSharing = 0;
    this.mapUnits = new ArrayList<HexButton>();

    JPanel menuPanel = new JPanel();
    menuPanel.setPreferredSize(new Dimension(200, 700));
    menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    menuPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
    menuPanel.setLayout(new GridLayout(5, 1));

    JButton restart = new JButton("Restart");
    restart.setHorizontalAlignment(SwingConstants.CENTER);
    restart.setFont(new Font("Arial", Font.BOLD, 25));
    restart.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    restart.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JButton endGame = new JButton("End Game");
    endGame.setHorizontalAlignment(SwingConstants.CENTER);
    endGame.setFont(new Font("Arial", Font.BOLD, 25));
    endGame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    JButton checkClue = new JButton("Check Clue");
    checkClue.setHorizontalAlignment(SwingConstants.CENTER);
    checkClue.setFont(new Font("Arial", Font.BOLD, 25));
    checkClue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    JButton rules = new JButton("Rules");
    rules.setHorizontalAlignment(SwingConstants.CENTER);
    rules.setFont(new Font("Arial", Font.BOLD, 25));
    rules.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    menuPanel.add(restart);
    menuPanel.add(endGame);
    menuPanel.add(checkClue);
    menuPanel.add(rules);


    JPanel playerPanel = new JPanel();
    playerPanel.setPreferredSize(new Dimension(200, 900));
    playerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    playerPanel.setLayout(new GridLayout(number, 1));


    for (int i = 1; i <= number; i++) {
      JPanel panel = new JPanel();
      JLabel player = new JLabel(controller.getPlayerList().get(i - 1).getName() + " ");
      player.setFont(new Font("Arial", Font.BOLD, 35));
      JLabel status;
      if (i == 1) {
        status = new JLabel("  initilal sharing...");
      } else {
    	  status = new JLabel("  waiting...");
      }
      
      JLabel cube = new PlayerTokenLabel("cube", controller.getPlayerList().get(i - 1).getColor());
      JLabel disc = new PlayerTokenLabel("disc", controller.getPlayerList().get(i - 1).getColor());
      playerStatus.add(status);
      panel.add(player);
      panel.add(cube);
      panel.add(disc);
      panel.add(status);
      panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
      playerPanel.add(panel);
    }

    JPanel mapPanel = new JPanel();
    mapPanel.setLayout(new HexLayout(6));

    List<Hexagon> mapList = controller.getMap();

    // Create the buttons
    for (int i = 0; i < 108; i++) {
      int index = i;
      HexButton mapUnit = new HexButton();
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.setOpaque(false);
      mapUnit.add(buttonPanel);
      mapPanel.add(mapUnit);
      mapUnits.add(mapUnit);
      //initial view of button
      Hexagon hexagon = mapList.get(i);
      if (Objects.equals(hexagon.getTerrain(), "swamp")) {
        mapUnit.setBackgroundImage("com/game/cryptid/images/swamp.png");
        if (Objects.equals(hexagon.getTerritory(), "cougar")){
          mapUnit.setBorderColor("red");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
      } else if (Objects.equals(hexagon.getTerrain(), "water")) {
        mapUnit.setBackgroundImage("com/game/cryptid/images/water.png");
        if (Objects.equals(hexagon.getTerritory(), "cougar")){
          mapUnit.setBorderColor("red");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else if (Objects.equals(hexagon.getTerritory(), "bear")){
          mapUnit.setBorderColor("black");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
      } else if (Objects.equals(hexagon.getTerrain(), "desert")) {
        mapUnit.setBackgroundImage("com/game/cryptid/images/desert.png");
        if (Objects.equals(hexagon.getTerritory(), "bear")){
          mapUnit.setBorderColor("black");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
      } else if (Objects.equals(mapList.get(i).getTerrain(), "forest")) {
        mapUnit.setBackgroundImage("com/game/cryptid/images/forest.png");
        if (Objects.equals(hexagon.getTerritory(), "cougar")){
          mapUnit.setBorderColor("red");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else if (Objects.equals(hexagon.getTerritory(), "bear")){
          mapUnit.setBorderColor("black");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
      } else if (Objects.equals(mapList.get(i).getTerrain(), "mountain")) {
        mapUnit.setBackgroundImage("com/game/cryptid/images/mountain.png");
        if (Objects.equals(hexagon.getTerritory(), "cougar")) {
          mapUnit.setBorderColor("red");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else if (Objects.equals(hexagon.getTerritory(), "bear")) {
          mapUnit.setBorderColor("black");
          mapUnit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
      }
      if(mapList.get(i).getStructuresList().size() != 0) {
        JLabel structure = new StructureLabel(mapList.get(i).getStructuresList().get(0).getName(),mapList.get(i).getStructuresList().get(0).getColor());
        buttonPanel.add(structure);
        mapUnit.add(buttonPanel);
      }

      // add event handler when a hexagon is selected for marking
      mapUnit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          for(int i = 0; i < number; i++) {
            Player player = controller.getPlayerList().get(i);
            // in round of player i
            if(player.getStatus()) {
              if(controller.getGameStatus().getInitialSharing()) {
                // if this hexagon has cube, then need to select another hexagon
                if(controller.hasCube(mapModel.getMapList().get(index))){
                  System.out.println("1");
                  break;
                }
                //mark
                if(controller.markAsCube(mapModel.getMapList().get(index), controller.getPlayerList().get(i))) {
                  JLabel cube = new PlayerTokenLabel("cube", player.getColor());
                  buttonPanel.add(cube);
                  mapUnit.add(buttonPanel);
                }

                numInitialSharing ++;

                //status
                playerStatus.get(player.getPlayerNumber()).setText("waiting...");
                player.outRound();
                Player nextPlayer = nextPlayer(player, controller.getPlayerList());
                nextPlayer.inRound();
                if (numInitialSharing == number*2) {
                  // finished initial information sharing
                  controller.getGameStatus().disableInitailSharing();
                  playerStatus.get(nextPlayer.getPlayerNumber()).setText("playing...");
                  doAskOrSearch(controller, nextPlayer);
                } else {
                  playerStatus.get(nextPlayer.getPlayerNumber()).setText("initial sharing...");
                }
                break;
              } else {
                if(controller.getGameStatus().getAsk()) {
                  //ask
                  // if this hexagon has cube, then need to select another hexagon
                  if(controller.hasCube(mapModel.getMapList().get(index))){
                    break;
                  }
                  // disable selected hexagon
                  mapUnit.enable(false);
                  //status for answering
                  int numPlayerSelected = playerSelected.getPlayerNumber();
                  playerStatus.get(controller.getPlayerList().get(numPlayerSelected).getPlayerNumber()).setText("answering...");
                  String token = doMarkHexagon(mapModel.getMapList().get(index), controller.getPlayerList().get(numPlayerSelected), controller);
                  playerStatus.get(controller.getPlayerList().get(numPlayerSelected).getPlayerNumber()).setText("waiting...");
                  //update view mark
                  if(Objects.equals(token, "cube")) {
                    JLabel cube = new PlayerTokenLabel("cube", playerSelected.getColor());
                    buttonPanel.add(cube);
                    mapUnit.add(buttonPanel);
                    //status
                    controller.getGameStatus().disableAsk();
                    controller.getGameStatus().enableSelect();
                    playerStatus.get(player.getPlayerNumber()).setText("selecting...");
                  } else if(Objects.equals(token, "disc")) {
                    JLabel disc = new PlayerTokenLabel("disc", playerSelected.getColor());
                    buttonPanel.add(disc);
                    mapUnit.add(buttonPanel);
                    //status
                    player.outRound();
                    playerStatus.get(player.getPlayerNumber()).setText("waiting...");
                    Player nextPlayer = nextPlayer(player, controller.getPlayerList());
                    nextPlayer.inRound();
                    controller.getGameStatus().disableAsk();
                    playerStatus.get(nextPlayer.getPlayerNumber()).setText("playing...");
                    doAskOrSearch(controller, nextPlayer);
                  }
                  // enable selected hexagon
                  mapUnit.enable(true);
                  break;

                } else if(controller.getGameStatus().getSearch()) {
                  //search
                  // if this hexagon has cube, then need to select another hexagon
                  if(controller.hasCube(mapModel.getMapList().get(index))){
                    break;
                  }
                  //mark current player's token
                  if(controller.markAsDisc(mapModel.getMapList().get(index), controller.getPlayerList().get(i))) {
                    JLabel disc = new PlayerTokenLabel("disc", player.getColor());
                    buttonPanel.add(disc);
                    mapUnit.add(buttonPanel);
                  }
                  // disable selected hexagon
                  mapUnit.enable(false);
                  Player newPlayer = player;
                  for(int j = 1; j < number; j++) {
                    newPlayer = nextPlayer(newPlayer, controller.getPlayerList());
                    playerStatus.get(newPlayer.getPlayerNumber()).setText("answering...");
                    String token = doMarkHexagon(mapModel.getMapList().get(i), newPlayer, controller);
                    playerStatus.get(newPlayer.getPlayerNumber()).setText("waiting...");
                    // update view mark
                    if(Objects.equals(token, "cube")) {
                      JLabel cube = new PlayerTokenLabel("cube", newPlayer.getColor());
                      buttonPanel.add(cube);
                      mapUnit.add(buttonPanel);
                      controller.getGameStatus().disableSearch();
                      controller.getGameStatus().enableSelect();
                      playerStatus.get(player.getPlayerNumber()).setText("selecting...");
                      break;
                    } else if(Objects.equals(token, "disc")) {
                      JLabel disc = new PlayerTokenLabel("disc", newPlayer.getColor());
                      buttonPanel.add(disc);
                      mapUnit.add(buttonPanel);
                    }

                  }
                  // enable selected hexagon
                  mapUnit.enable(true);
                  if(controller.gameWon(mapModel.getMapList().get(index))) {
                    // win the game
                    //status
                    controller.getGameStatus().disableSearch();
                    for(int j = 0; j < playerStatus.size(); j++){
                      if(j == player.getPlayerNumber()){
                        playerStatus.get(j).setText("win the game!");
                      } else{
                        playerStatus.get(j).setText("lose");
                      }
                    }
                    // show answer
                    reveal(index);
                    // show winner
                    showWinner(player);
                  } else {
                    controller.getGameStatus().disableSearch();
                    controller.getGameStatus().enableSelect();
                    playerStatus.get(player.getPlayerNumber()).setText("selecting...");
                  }
                  break;
                } else if (controller.getGameStatus().getSelect()) {
                  //search failed
                  // if this hexagon has cube, then need to select another hexagon
                  if(controller.hasCube(mapModel.getMapList().get(index))){
                    break;
                  }
                  // mark a cube in new hexagon
                  if(controller.markAsCube(mapModel.getMapList().get(index), controller.getPlayerList().get(i))) {
                    JLabel cube = new PlayerTokenLabel("cube", player.getColor());
                    buttonPanel.add(cube);
                    mapUnit.add(buttonPanel);
                  }
                  //status
                  controller.getGameStatus().disableSelect();
                  player.outRound();
                  playerStatus.get(player.getPlayerNumber()).setText("waiting...");
                  Player nextPlayer = nextPlayer(player, controller.getPlayerList());
                  nextPlayer.inRound();
                  playerStatus.get(nextPlayer.getPlayerNumber()).setText("playing...");
                  doAskOrSearch(controller, nextPlayer);
                  break;
                } else if(controller.getGameStatus().getEnd()){
                  break;
                }
              }
            }
          }
        }
      });
    }

    this.add(menuPanel,BorderLayout.WEST);
    this.add(playerPanel, BorderLayout.CENTER);
    this.add(mapPanel,BorderLayout.EAST);

    restart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new StartView().setVisible(true);
        setVisible(false);
        dispose();
      }
    });

    endGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       //show crptid
       reveal((controller.getAnswer().getHexagon().getX_coordinate()-1)*12 + (controller.getAnswer().getHexagon().getY_coordinate()-1));

          for (JLabel status : playerStatus) {
              status.setText("end game");
          }
       //disable buttons
       controller.getGameStatus().disableInitailSharing();
       controller.getGameStatus().disableAsk();
       controller.getGameStatus().disableSearch();
       controller.getGameStatus().disableSelect();
       controller.getGameStatus().enableEnd();
      }
    });

    checkClue.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.getClueView().setVisible(true);
      }
    });

    rules.addActionListener(e -> {JOptionPane.showMessageDialog(this, "fhfrehifgegbehugurhieugir");});
  }

  public Player nextPlayer(Player player, List<Player> playerList) {
	  if(player.getPlayerNumber() == playerList.size() - 1) {
		  return playerList.get(0);
	  } else {
		  return playerList.get(player.getPlayerNumber() + 1);
	  }
  }
  
  /**
   * Set the model class for the game client.
   *
   * @param mapModel reference to the map model class {@link MapModel}
   */
  public void setModel(MapModel mapModel) {
    this.mapModel = mapModel;
  }

  /**
   * reveal the answer
   */
  public void reveal(int index) {
    mapUnits.get(index).setBackgroundImage("com/game/cryptid/images/cryptid.jpg");
  }

  /**
   * This method is used to display the winner popup window.
   *
   * @param winner the winning player
   */
  public void showWinner(Player winner) {
    ShowWinnerDialogView showWinnerDialogView = new ShowWinnerDialogView(this, winner);
    showWinnerDialogView.setVisible(true);
  }

  /**
   * This method is invoked to perform the operation of Ask or Search.
   * @param player the player who is asking
   */
  public void doAskOrSearch(Controller controller, Player player) {
    // Ask or Search dialog is instantiated and displayed
    AskOrSearchDialogView askOrSearchDialog = new AskOrSearchDialogView(thisFrame);
    askOrSearchDialog.setVisible(true);
    // Get the choice selected by user
    AskOrSearchDialogView.AskOrSearch choice = askOrSearchDialog.getAskOrSearchChoice();
    if (choice == AskOrSearchDialogView.AskOrSearch.ASK) {
      controller.getGameStatus().enableAsk();
      System.out.println("DEBUG INFO: player selected Ask");
      // user selected Ask so invoke Ask Dialog
      AskDialogView askDialogView = new AskDialogView(this, controller.getPlayerList(), player);
      askDialogView.setVisible(true);
      // Get the player selected
      playerSelected = askDialogView.getPlayerSelected();
      System.out.println("DEBUG INFO: Player have chosen player " + playerSelected + " to ask");
    } else {
      controller.getGameStatus().enableSearch();
      System.out.println("DEBUG INFO: player selected Search");
    }
  }

  /**
   * This method is invoked after a hexagon is selected for marking it.
   *
   * @param hexagon The hexagon that is selected for marking.
   */
  public String doMarkHexagon(Hexagon hexagon, Player player, Controller controller) {
    // popup window for marking the hexagon
    MarkHexagonDialogView markHexagonDialogView = new MarkHexagonDialogView(this);
    markHexagonDialogView.setVisible(true);
    // get the token selected by player from popup window
    String token = markHexagonDialogView.getToken();
    // set the token on the selected hexagon
    if (Objects.equals(token, "cube")) {
    	if (!controller.markAsCube(hexagon, player)) {
    		return "fail";
    	} 
    } else if (Objects.equals(token, "disc")) {
    	if (!controller.markAsDisc(hexagon, player)) {
    		return "fail";
    	}
    }
    return token;
  }
}
