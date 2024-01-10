package com.game.cryptid.view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JFrame {

  public StartView() throws HeadlessException {
    super();
    this.setTitle("Start View");
    this.setSize(1024, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel title = new JLabel("Cryptid");
    title.setFont(new Font("宋体", Font.BOLD, 80));
    title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    JButton newGame = new JButton("  New Game  ");
    newGame.setAlignmentX(JButton.CENTER_ALIGNMENT);

    this.add(Box.createVerticalGlue());
    this.add(title);
    this.add(Box.createVerticalStrut(40));
    this.add(newGame);
    this.add(Box.createVerticalGlue());

    newGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new SelectView().setVisible(true);
        setVisible(false);
        dispose();
      }
    });

  }

}
