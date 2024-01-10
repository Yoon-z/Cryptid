package com.game.cryptid.view;

import com.game.cryptid.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClueView extends JFrame {

  public ClueView(int number, Controller controller) throws HeadlessException {

    super();
    this.setTitle("Clue View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel checkClue = new JLabel("Please check your own clue:");
    checkClue.setFont(new Font("宋体", Font.PLAIN, 60));
    checkClue.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JLabel warning = new JLabel("*Click your name and check your clue, make sure your partner cannot see your clue.");
    warning.setFont(new Font("宋体", Font.PLAIN, 20));
    warning.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JButton confirm = new JButton("Confirm");
    confirm.setAlignmentX(JButton.CENTER_ALIGNMENT);

    this.add(Box.createVerticalGlue());
    this.add(checkClue);
    this.add(Box.createVerticalStrut(40));


    for (int i = 1; i <= number; i++) {
      JButton button = new JButton("Player " + i);
      String clue = controller.getAnswer().getClueList().get(i - 1).getContent();

      button.addActionListener(e -> {
        JOptionPane.showMessageDialog(this, clue);
      });

      button.setAlignmentX(JButton.CENTER_ALIGNMENT);
      this.add(button);
    }

    this.add(Box.createVerticalStrut(40));
    this.add(confirm);
    this.add(Box.createVerticalStrut(40));
    this.add(warning);
    this.add(Box.createVerticalGlue());


    confirm.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);

        if(controller.getGameStatus().getGameStatus() == false){
          new GameBoardView(number, controller).setVisible(true);

          //player 1: status true
          controller.getPlayerList().get(0).inRound();
          //initialise sharing
          controller.getGameStatus().enableInitailSharing();

          controller.getGameStatus().startGame();
        }
        dispose();
      }
    });
  }
}
