package com.pandavoid.snakegame.ui.window;

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
    Panel CreatePanel(int y ,int x ,int width , int height ){
        Panel panel = new Panel(width ,height );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        window.add(panel.getpanel(),gbc);
        return panel;
    }
    JLabel CreateLabel(int x, int y, String text) {
        JLabel label = new JLabel(text);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        label.setFont(new Font("Monospaced", Font.BOLD, 80));
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = x;
        gbc.gridy = y;
        window.add(label,gbc);
        return label;
    }
    //create function for create a button 
    JButton CreateButton(int x, int y, int width ,String text, Color bgColor, Color textColor, ActionListener action){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton button = new JButton(text);
        //set size ,color and padding
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.addActionListener(action);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(button,gbc);
        return button;
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
    void ClearDisplay() {
        Component[] components = window.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton jbutton) {
	            window.remove(jbutton);
            } else if (component instanceof JLabel jlabel) {
                window.remove(jlabel);
            }
        }
    }
    void UpdateDisplay() {
        window.revalidate();
        window.repaint();
    }
}
