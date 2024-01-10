package com.game.cryptid.view;

import com.game.cryptid.controller.ControllerNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClueViewNetwork extends JFrame {
  public ClueViewNetwork(ControllerNetwork controller) throws HeadlessException {
    super();
    this.setTitle("Network Clue View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel checkClue = new JLabel("Please check your own clue:");
    checkClue.setFont(new Font("宋体", Font.PLAIN, 60));
    checkClue.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JButton button = new JButton("Your Clue");
    button.setAlignmentX(JButton.CENTER_ALIGNMENT);

    JButton confirm = new JButton("Confirm");
    confirm.setAlignmentX(JButton.CENTER_ALIGNMENT);

    this.add(Box.createVerticalGlue());
    this.add(checkClue);
    this.add(Box.createVerticalStrut(40));
    this.add(button);
    this.add(Box.createVerticalStrut(40));
    this.add(confirm);
    this.add(Box.createVerticalGlue());

    confirm.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.sendCheckedClueConfirm();
        setVisible(false);
        dispose();
      }
    });

  }
}
