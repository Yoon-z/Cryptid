package com.game.cryptid.images;

import javax.swing.*;
import java.awt.*;

public class StructureLabel extends JLabel {

    private static final Color WHITE_COLOR = Color.WHITE;
    private static final Color BLUE_COLOR = Color.BLUE;
    private static final Color GREEN_COLOR = Color.GREEN;

    private String shapeType;
    private String color;

    public StructureLabel(String shapeType, String color) {
        this.shapeType = shapeType;
        this.color = color;
        
        setPreferredSize(new Dimension(20, 20));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g.create();

        switch (shapeType) {
            case "Shack":
                drawTriangle(g2d, width, height);
                break;
            case "Stone":
                drawOctagon(g2d, width*2, height*2);
                break;
        }

        g2d.dispose();
    }

    private void drawTriangle(Graphics2D g2d, int width, int height) {
        int[] xPoints = {width / 2, 0, width};
        int[] yPoints = {0, height, height};
        int nPoints = 3;

        switch (color) {
        case "WHITE":
        	g2d.setColor(WHITE_COLOR);
            g2d.fillPolygon(xPoints, yPoints, nPoints);
            g2d.drawPolygon(xPoints, yPoints, nPoints);
            break;
        case "BLUE":
        	g2d.setColor(BLUE_COLOR);
            g2d.fillPolygon(xPoints, yPoints, nPoints);
            g2d.drawPolygon(xPoints, yPoints, nPoints);
            break;
        case "GREEN":
        	g2d.setColor(GREEN_COLOR);
            g2d.fillPolygon(xPoints, yPoints, nPoints);
            g2d.drawPolygon(xPoints, yPoints, nPoints);
            break;
        }
    }

       
    private void drawOctagon(Graphics2D g2d, int width, int height) {
        int side = Math.min(width, height) - 20;
        int x = (width - side) / 2;
        int y = (height - side) / 2;

        Polygon polygon = new Polygon();
        for (int i = 0; i < 8; i++) {
            int angle = i * 45;
            int px = x + (int) (side / 2 * Math.cos(Math.toRadians(angle)));
            int py = y + (int) (side / 2 * Math.sin(Math.toRadians(angle)));
            polygon.addPoint(px, py);
        }
        
        switch (color) {
        case "WHITE":
        	g2d.setColor(WHITE_COLOR);
            g2d.fillPolygon(polygon);
            g2d.drawPolygon(polygon);
            break;
        case "BLUE":
        	g2d.setColor(BLUE_COLOR);
            g2d.fillPolygon(polygon);
            g2d.drawPolygon(polygon);
            break;
        case "GREEN":
        	g2d.setColor(GREEN_COLOR);
            g2d.fillPolygon(polygon);
            g2d.drawPolygon(polygon);
            break;
        }
    }
}

