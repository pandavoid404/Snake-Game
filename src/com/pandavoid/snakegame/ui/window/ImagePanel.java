package com.pandavoid.snakegame.ui.window;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class ImagePanel extends JPanel {
    private Image backgroundImage; // Store the background image

    public ImagePanel(String imagePath, int width, int height) {
        // Load the background image during initialization
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println("Error: Could not load background image from path: " + imagePath);
            e.printStackTrace();
        }

        // Set size
        setPreferredSize(new Dimension(width, height));
        setLayout(new GridBagLayout()); // Optional layout
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
    void CreateLabel(String text) {
        JLabel label = new JLabel(text);
        //add GridBagConstraints and add padding
        GridBagConstraints gbc = new GridBagConstraints();
        label.setFont(new Font("Monospaced", Font.BOLD, 10));
        label.setForeground(Color.white);
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(label, gbc);
    }
}
