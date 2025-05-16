package com.pandavoid.snakegame.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class ImagePanel extends JPanel {
    private Image backgroundImage; // Store the background image

    public ImagePanel(String imagePath, int width, int height,int x,int y) {
        // Load the background image during initialization
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println("Error: Could not load background image from path: " + imagePath);
            e.printStackTrace();
        }
        // Set size
        setPreferredSize(new Dimension(width, height));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image only if it's loaded
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            System.err.println("Warning: Background image is null.");
        }
    }
    void createLabel(String text, int x, int y, int size, Color background_color) {
        JLabel label = new JLabel(text);
        //add GridBagConstraints and add padding
        GridBagConstraints gbc = new GridBagConstraints();
        label.setFont(new Font("Monospaced", Font.BOLD, size));
        label.setForeground(Color.white);
        label.setBackground(background_color);
        label.setOpaque(true);
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(label, gbc);
    }
    void createButton(ActionListener action) {
        GridBagConstraints gbc = new GridBagConstraints();
        JButton button = new JButton("Change Color");
        //set size ,color and padding
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setFocusPainted(false);
        button.addActionListener(action);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(button, gbc);
    }

    public void addSnakePanel(Panel snakePanel) {
        this.add(snakePanel.getPanel());
    }
}
