package com.game.cryptid.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class HexButton extends JButton {

    private static final long serialVersionUID = 8703517515706326251L;
    Polygon bounds;
    String color;

    private BufferedImage backgroundImage;

    /**
     * Creates a hexagonal button with a single character label
     */
    public HexButton() {
        this.calculateBounds();
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
        this.color = "null";
    }
    
    /**
     * Creates a hexagon of certain height / width and ratio multiplier
     * @param width
     * @param height
     * @param ratio
     * @return
     */
    private Polygon hexagon(int width, int height, double ratio) {
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
            int x = width / 2 + (int)((width - 2) / 2 * Math.cos(i * 2 * Math.PI / 6) * ratio);
            int y = height / 2 + (int)((height - 2) / 2 * Math.sin(i * 2 * Math.PI / 6) * ratio);            
            hexagon.addPoint(x,y);
        }        
        return hexagon;
    }
    
    private void calculateBounds() {                
        this.bounds = this.hexagon(this.getWidth(), this.getHeight(), 1.0);
    }

    /**
     * Returns whether a certain point is within the bounds of this button.
     */
    @Override
    public boolean contains(Point p) {
        return this.bounds.contains(p);
    }

    /**
     * Returns whether supplied x,y coordinates is within the bounds of this button.
     */
    @Override
    public boolean contains(int x, int y) {
        return this.bounds.contains(x, y);
    }

    /**
     * Sets the dimension of the button
     */
    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        this.calculateBounds();
    }

    /**
     * Sets the dimension of the button
     */
    @Override
    public void setSize(int w, int h) {
        super.setSize(w, h);
        this.calculateBounds();
    }

    /**
     * Sets the bounds of the button
     */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        this.calculateBounds();
    }

    /**
     * Sets the bounds of the button
     */
    @Override
    public void setBounds(Rectangle r) {
        super.setBounds(r);
        this.calculateBounds();
    }

    public void setBackgroundImage(String imagePath) {
        try {
            ClassLoader classL = getClass().getClassLoader();
            backgroundImage = ImageIO.read(Objects.requireNonNull(classL.getResource(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Draws the button
     */
    @Override
    protected void paintComponent(Graphics graphics) {

        Graphics2D g2d = (Graphics2D) graphics;

        // Draw the black border
        if(color == "red"){
            graphics.setColor(Color.red);
            Polygon stroke = this.hexagon(getWidth(), getHeight(), 1.05);
            graphics.drawPolygon(stroke);
            graphics.fillPolygon(stroke);
        } else if(color == "black"){
            graphics.setColor(Color.black);
            Polygon stroke = this.hexagon(getWidth(), getHeight(), 1.05);
            graphics.drawPolygon(stroke);
            graphics.fillPolygon(stroke);
        }

        // Draw the inside background
        Polygon inside = this.hexagon(getWidth(), getHeight(), 0.9);
        graphics.setColor(getBackground());
        graphics.drawPolygon(inside);
        graphics.fillPolygon(inside);

        if (backgroundImage != null) {
            TexturePaint texturePaint = new TexturePaint(backgroundImage, bounds.getBounds2D());
            g2d.setPaint(texturePaint);
            g2d.fillPolygon(inside);
        }
        
    }

    public void setBorderColor(String s){
        this.color = s;
    }


}