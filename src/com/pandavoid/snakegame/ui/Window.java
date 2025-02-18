package com.pandavoid.snakegame.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class Window {
    private final JFrame window;
    Window(String title, Boolean IsMainWindow,int width,int height) {
        window = new JFrame(title);
        if (IsMainWindow) {
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        window.setSize(width,height);
        window.setLayout(new GridBagLayout());
    }

    void CreateLabel(int x, int y, String text) {
        JLabel label = new JLabel(text);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = x;
        gbc.gridy = y;
        window.add(label,gbc);
    }
    //create function for create a button 
    void CreateButton(int x, int y, String text, Color bgColor, Color textColor, ActionListener action){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton create_button = new JButton(text);
        //set size ,color and padding
        create_button.setPreferredSize(new Dimension(200, 50));
        create_button.setBackground(bgColor);
        create_button.setForeground(textColor);
        create_button.setFocusPainted(false);
        create_button.addActionListener(action);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(create_button,gbc);
    }
    void ShowDisplay() {
        window.setVisible(true);
    }
}
