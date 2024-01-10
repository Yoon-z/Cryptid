package com.game.cryptid.view;

import com.game.cryptid.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectView extends JFrame {

  public SelectView() throws HeadlessException {

    super();
    this.setTitle("Select View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel title = new JLabel("Cryptid");
    title.setFont(new Font("宋体", Font.BOLD, 80));
    title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JLabel selectMode = new JLabel("Please select your game mode:");
    selectMode.setFont(new Font("宋体", Font.PLAIN, 40));
    selectMode.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JButton hotSeatMode = new JButton("Hot Seat");
    JButton netWorkMode = new JButton("Network");
    hotSeatMode.setAlignmentX(JButton.CENTER_ALIGNMENT);
    netWorkMode.setAlignmentX(JButton.CENTER_ALIGNMENT);

    this.add(Box.createVerticalGlue());
    this.add(title);
    this.add(Box.createVerticalStrut(40));
    this.add(selectMode);
    this.add(Box.createVerticalStrut(40));
    this.add(hotSeatMode);
    this.add(netWorkMode);
    this.add(Box.createVerticalGlue());

    hotSeatMode.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Controller controller = new Controller();
        new SelectNumberView(controller).setVisible(true);
        setVisible(false);
        dispose();
      }
    });

    netWorkMode.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new NameViewNetwork().setVisible(true);
        setVisible(false);
        dispose();
      }
    });

  }

}
