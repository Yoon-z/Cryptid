package com.game.cryptid.view;

import com.game.cryptid.controller.Controller;
import com.game.cryptid.controller.ControllerNetwork;
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
public class GameBoardViewNetwork extends JFrame {

    /** number of player in the game. */

    /** TODO: reference to map model class. */
    private MapModel mapModel;

    private  JFrame thisFrame;

    private static int numInitialSharing;
    private static Player playerSelected;
    private static JLabel status;
    private static List<HexButton> mapUnits;
    private static List<JPanel> buttonPanels;


    /**
     * Constructor that creates a new instance of the class {@link GameBoardView}.
     *
     * @param number the number of player in the game
     * @param controller reference to the game controller class {@link Controller}
     * @throws HeadlessException if target machine does not support keyboard
     */
    public GameBoardViewNetwork(int number, ControllerNetwork controller) throws HeadlessException {

        super();
        this.thisFrame = this;
        this.setTitle("Game Board");
        this.setSize(new Dimension(1600, 1000));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        this.mapModel = new MapModel();
        this.status = new JLabel();
        this.numInitialSharing = 0;
        this.mapUnits = new ArrayList<HexButton>();
        this.buttonPanels = new ArrayList<JPanel>();

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



        JPanel panel = new JPanel();
        JLabel player = new JLabel(controller.getPlayer().getName() + " ");
        player.setFont(new Font("Arial", Font.BOLD, 35));
        if (controller.getPlayer().getPlayerNumber() == 1) {
            status = new JLabel("  initilal sharing...");
        } else {
            status = new JLabel("  waiting...");
        }

        JLabel cube = new PlayerTokenLabel("cube", controller.getPlayer().getColor());
        JLabel disc = new PlayerTokenLabel("disc", controller.getPlayer().getColor());
        panel.add(player);
        panel.add(cube);
        panel.add(disc);
        panel.add(status);
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        playerPanel.add(panel);


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
            buttonPanels.add(buttonPanel);
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
                    if (controller.getPlayer().getStatus() == true) {
                        if (controller.getGameStatus().getInitialSharing() == true) {
                            // mark
                            if (controller.markAsCube(mapModel.getMapList().get(index), controller.getPlayer())) {
                                JLabel cube = new PlayerTokenLabel("cube", controller.getPlayer().getColor());
                                buttonPanel.add(cube);
                                mapUnit.add(buttonPanel);

                                numInitialSharing++;
                                if (numInitialSharing == 2) {
                                    // end the initial sharing phase
                                    controller.getGameStatus().disableInitailSharing();
                                    controller.sendEndInitialSharing();
                                } else{
                                    controller.sendFinishedInitialSharing(index);
                                }

                                status.setText("waiting...");
                                controller.getPlayer().outRound();
                            } else if (controller.getGameStatus().getAsk() == true) {
                                // send message to server
                                controller.sendAsk(playerSelected, index);

                                controller.getGameStatus().disableAsk();
                            } else if (controller.getGameStatus().getSearch() == true) {
                                // send message to server
                                controller.sendSearch(index);

                                controller.getGameStatus().disableSearch();
                            } else if (controller.getGameStatus().getSelect() == true) {
                                // mark
                                if (controller.markAsCube(mapModel.getMapList().get(index), controller.getPlayer())) {
                                    JLabel cube = new PlayerTokenLabel("cube", controller.getPlayer().getColor());
                                    buttonPanel.add(cube);
                                    mapUnit.add(buttonPanel);
                                }

                                // send message to server
                                controller.sendSelect(index);
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
                // send message to server to restart game for all players
                controller.sendRestart();

                new StartView().setVisible(true);
                setVisible(false);
                dispose();
            }
        });

        endGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // send message to server to end game for all players
                controller.sendEndGame();

                //show crptid
                reveal((controller.getAnswer().getHexagon().getX_coordinate()-1)*12 + (controller.getAnswer().getHexagon().getY_coordinate()-1));
                status.setText("end game");

                //disable buttons
                controller.getGameStatus().disableInitailSharing();
                controller.getGameStatus().disableAsk();
                controller.getGameStatus().disableSearch();
                controller.getGameStatus().disableSelect();
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

    public JLabel getStatus(){
        return status;
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
    public void doAskOrSearch(ControllerNetwork controller, Player player) {
        // Ask or Search dialog is instantiated and displayed
        AskOrSearchDialogView askOrSearchDialog = new AskOrSearchDialogView(thisFrame);
        askOrSearchDialog.setVisible(true);
        // Get the choice selected by user
        AskOrSearchDialogView.AskOrSearch choice = askOrSearchDialog.getAskOrSearchChoice();
        if (choice == AskOrSearchDialogView.AskOrSearch.ASK) {
            controller.getGameStatus().enableAsk();
            status.setText("asking...");

            System.out.println("DEBUG INFO: player selected Ask");
            // user selected Ask so invoke Ask Dialog
            AskDialogView askDialogView = new AskDialogView(this, controller.getPlayerList(), player);
            askDialogView.setVisible(true);
            // Get the player selected
            playerSelected = askDialogView.getPlayerSelected();
            System.out.println("DEBUG INFO: Player have chosen player " + playerSelected + " to ask");
        } else {
            controller.getGameStatus().enableSearch();
            status.setText("searching...");

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

    public List<JPanel> getButtonPanels(){
        return buttonPanels;
    }

    public List<HexButton> getMapUnits(){
        return mapUnits;
    }
}
