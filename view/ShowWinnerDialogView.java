package com.game.cryptid.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.game.cryptid.model.entity.Player;

/**
 * This class design and implement the Winner dialog
 * window with winning player.
 */
public class ShowWinnerDialogView extends  JDialog {

  private JDialog thisDialog;
  /**
   * Constructor that creates a new instance of class {@link ShowWinnerDialogView}.
   *
   * @param parent the parent JFrame of this dialog.
   * @param winner the winning player
   */
  public ShowWinnerDialogView(JFrame parent, Player winner) {
    super(parent, true);
    thisDialog = this;
    setLocationRelativeTo(parent);
    setSize(new Dimension(500, 150));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());
    String msg = "<html>Congratulations, you've found the habitat!<br>";
    msg += "The winner is " + winner.getName() + "!</html>";
    JLabel msgLabel = new JLabel(msg);
    msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    container.add(msgLabel, BorderLayout.CENTER);

    JPanel p = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    p.setBorder(new EmptyBorder(5, 5, 5, 5));
    JButton okButton = new JButton("Ok");
    p.add(okButton);
    okButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        thisDialog.dispose();
      }
    });
    container.add(p, BorderLayout.SOUTH);
    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
  }
}
