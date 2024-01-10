package com.game.cryptid.view;

import com.game.cryptid.model.entity.Player;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * This class design and implement the Ask dialog
 * window for user to select a player to ask.
 */
public class AskDialogView extends JDialog {

  /** the selected player. */
  private Player playerSelected;

  /** array of button for player to be selected. */
  private List<JButton> playerButton;

  private JDialog thisDialog;

  /**
   * Constructor that creates a new instance of class {@link AskDialogView}.
   *
   * @param parent the parent JFrame of this dialog.
   * @param players list of all Player instances of the game
   * @param askPlayer the asking player
   */
  public AskDialogView(JFrame parent, List<Player> players, Player askPlayer) {
    super(parent, true);
    thisDialog = this;
    setLocationRelativeTo(parent);
    setSize(new Dimension(500, 150));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());
    JLabel msgLabel = new JLabel("Which player do you want to ask?");
    msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    container.add(msgLabel, BorderLayout.CENTER);

    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
    p.setBorder(new EmptyBorder(5, 5, 5, 5));
    playerButton = new ArrayList<JButton>();
    for (int i = 0; i < players.size(); i++) {
      Player player = players.get(i);
      if (player.getPlayerNumber() != askPlayer.getPlayerNumber()) {
        JButton button = new JButton(player.getName());
        button.setActionCommand(String.format("%d", player.getPlayerNumber()));
        playerButton.add(button);
        p.add(button);
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            playerSelected = player;
            thisDialog.dispose();
          }
        });
      }
    }
    container.add(p, BorderLayout.SOUTH);
    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
  }

  /**
   * Get the number of the selected player.
   *
   * @return the selected player.
   */
  public Player getPlayerSelected() {
    return playerSelected;
  }


}
