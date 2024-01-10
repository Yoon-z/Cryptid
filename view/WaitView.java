package com.game.cryptid.view;

import javax.swing.*;
import java.awt.*;

public class WaitView extends JFrame {

  public WaitView() throws HeadlessException {
    super();
    this.setTitle("Wait View");
    this.setSize(800, 400);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    this.setBackground(Color.GRAY);

    JLabel waitInfo = new JLabel("Waiting for the other players...");
    waitInfo.setFont(new Font("宋体", Font.PLAIN, 45));
    waitInfo.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    this.add(Box.createVerticalGlue());
    this.add(waitInfo);
    this.add(Box.createVerticalGlue());
  }

}
