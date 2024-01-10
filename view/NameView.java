package com.game.cryptid.view;

import com.game.cryptid.controller.Controller;
import com.game.cryptid.model.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NameView extends JFrame {
  private static List<JTextField> name;

  public NameView(int number, Controller controller) throws HeadlessException {

    super();
    this.setTitle("Name View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);
    this.name = new ArrayList<JTextField>();

    JLabel enterName = new JLabel("Please enter your name:");
    enterName.setFont(new Font("Arial", Font.PLAIN, 60));
    enterName.setAlignmentX(JLabel.CENTER_ALIGNMENT);


    JButton confirm = new JButton("Confirm");
    confirm.setAlignmentX(JButton.CENTER_ALIGNMENT);



    this.add(Box.createVerticalGlue());
    this.add(enterName);
    this.add(Box.createVerticalStrut(40));

    for (int i = 1; i <= number; i++) {

      JPanel panel = new JPanel();
      JLabel playerNumber = new JLabel("Player " + i);
      JTextField nameField = new JTextField(16);
      panel.add(playerNumber);
      panel.add(nameField);
      panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
      this.add(panel);
      name.add(nameField);
    }

    this.add(Box.createVerticalStrut(40));
    this.add(confirm);
    this.add(Box.createVerticalGlue());


    confirm.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < name.size(); i++) {
          controller.addPlayer(new Player(name.get(i).getText(), i));
        }
        setVisible(false);
        dispose();
        ClueView clueView = new ClueView(number, controller);
        controller.setClueView(clueView);
        clueView.setVisible(true);
      }
    });
  }
}
