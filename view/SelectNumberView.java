package com.game.cryptid.view;

import com.game.cryptid.controller.Controller;
import com.game.cryptid.controller.ControllerNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectNumberView extends JFrame {

  public SelectNumberView(Controller controller) throws HeadlessException {

    super();
    this.setTitle("Select Number View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel title = new JLabel("Cryptid");
    title.setFont(new Font("宋体", Font.BOLD, 80));
    title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JLabel selectNumber = new JLabel("Please select the number of game:");
    selectNumber.setFont(new Font("宋体", Font.PLAIN, 40));
    selectNumber.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JButton number3 = new JButton(" 3 ");
    JButton number4 = new JButton(" 4 ");
    JButton number5 = new JButton(" 5 ");
    number3.setAlignmentX(JButton.CENTER_ALIGNMENT);
    number4.setAlignmentX(JButton.CENTER_ALIGNMENT);
    number5.setAlignmentX(JButton.CENTER_ALIGNMENT);

    this.add(Box.createVerticalGlue());
    this.add(title);
    this.add(Box.createVerticalStrut(40));
    this.add(selectNumber);
    this.add(Box.createVerticalStrut(40));
    this.add(number3);
    this.add(number4);
    this.add(number5);
    this.add(Box.createVerticalGlue());


    number3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(controller.getName() == "controller"){
          controller.setAnswer(3);
          new NameView(3, controller).setVisible(true);
          setVisible(false);
          dispose();
        } else if(controller.getName() == "network controller"){
          ControllerNetwork.sendSelectedNumber(3);
          setVisible(false);
          dispose();
        }
      }
    });

    number4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(controller.getName() == "controller"){
          controller.setAnswer(4);
          NameView nameView = new NameView(4, controller);
          nameView.setVisible(true);
          setVisible(false);
          dispose();
        } else if(controller.getName() == "network controller"){
          ControllerNetwork.sendSelectedNumber(4);
          setVisible(false);
          dispose();
        }
      }
    });

    number5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(controller.getName() == "controller"){
          controller.setAnswer(5);
          new NameView(5, controller).setVisible(true);
          setVisible(false);
          dispose();
        } else if(controller.getName() == "network controller"){
          ControllerNetwork.sendSelectedNumber(5);
          setVisible(false);
          dispose();
        }
      }
    });
  }
}
