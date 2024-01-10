package com.game.cryptid.view;

import com.game.cryptid.controller.ControllerNetwork;
import com.game.cryptid.model.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameViewNetwork extends JFrame {

  public NameViewNetwork() throws HeadlessException {
    super();
    this.setTitle("Network Name View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel enterName = new JLabel("Please enter your name:");
    enterName.setFont(new Font("Arial", Font.PLAIN, 60));
    enterName.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JButton confirm = new JButton("Confirm");
    confirm.setAlignmentX(JButton.CENTER_ALIGNMENT);

    JPanel jPanel = new JPanel();
    jPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
    JLabel player = new JLabel("Player: ");
    JTextField playerText = new JTextField(16);
    jPanel.add(player);
    jPanel.add(playerText);

    this.add(Box.createVerticalGlue());
    this.add(enterName);
    this.add(Box.createVerticalStrut(40));
    this.add(jPanel);
    this.add(Box.createVerticalStrut(40));
    this.add(confirm);
    this.add(Box.createVerticalGlue());

    confirm.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ControllerNetwork controller = new ControllerNetwork();
        controller.logIn(controller);

        // add player to playerlist
        String name = playerText.getText();
        Player player = new Player(name, controller.getPlayerList().size() + 1);
        controller.addPlayer(player);

        setVisible(false);
        dispose();
      }
    });
  }
}
