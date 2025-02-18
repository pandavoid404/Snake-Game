package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class Window {
    private final JFrame window;
    Window(String title,int width,int height) {
        window = new JFrame(title);
        window.setSize(width,height);
        window.setLayout(new GridBagLayout());
    }
    void SetMainWindow(Boolean IsMainWindow) {
        if (IsMainWindow) {
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    void CreateLabel(int x, int y, String text) {
        JLabel label = new JLabel(text);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        label.setFont(new Font("Monospaced", Font.BOLD, 80));
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
    void Close() {
        window.dispose();
    }
    void HideControls(Boolean hidden) {
        window.setUndecorated(hidden);
    }
    void SetPosition(Point location) {
        window.setLocation(location.x,location.y);
    }
    int GetWidth() {
        return window.getWidth();
    }
    int GetHeight() {
        return window.getHeight();
    }
    void SetBGColor(Color color) {
        window.getContentPane().setBackground(color);
    }
    Point GetPosition() {
        return window.getLocation();
    }
}
