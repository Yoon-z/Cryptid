package com.game.cryptid.images;

import javax.swing.*;
import java.awt.*;

public class PlayerTokenLabel extends JLabel {

    private String shape;
    private String color;

    public PlayerTokenLabel(String shape, String color) {
        this.shape = shape;
        this.color = color;
        setPreferredSize(new Dimension(15, 15));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        if (shape == "disc") {
            switch (color) {
            case "yellow":
            	g2d.setColor(new Color(255, 124, 0));
            	g.fillOval(0, 0, width, height);
                break;
            case "pink":
            	g2d.setColor(new Color(204, 0, 102));
            	g.fillOval(0, 0, width, height);
                break;
            case "green":
            	g2d.setColor(new Color(0, 100, 0));
            	g.fillOval(0, 0, width, height);
                break;
            case "purple":
            	g2d.setColor(new Color(138, 43, 226));
            	g.fillOval(0, 0, width, height);
                break;
            case "blue":
            	g2d.setColor(new Color(8, 46, 84));
            	g.fillOval(0, 0, width, height);
                break;
        }
        } else if (shape == "cube") {
        	switch (color) {
            case "yellow":
            	g2d.setColor(new Color(255, 124, 0));
            	g2d.fillRect(0, 0, width, height);
                break;
            case "pink":
            	g2d.setColor(new Color(204, 0, 102));
            	g2d.fillRect(0, 0, width, height);
                break;
            case "green":
            	g2d.setColor(new Color(0, 100, 0));
            	g2d.fillRect(0, 0, width, height);
                break;
            case "purple":
            	g2d.setColor(new Color(138, 43, 226));
            	g2d.fillRect(0, 0, width, height);
                break;
            case "blue":
            	g2d.setColor(new Color(8, 46, 84));
            	g2d.fillRect(0, 0, width, height);
                break;
        }
        }
    }
}
