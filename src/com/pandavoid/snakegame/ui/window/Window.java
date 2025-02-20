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
    void SetMainWindow() {
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    Panel CreatePanel(int x ){
        Panel panel = new Panel(500, 700);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = 0;
        window.add(panel.GetPanel(),gbc);
        return panel;
    }
    void CreateLabel(String text, int size, int x, int y) {
        JLabel label = new JLabel("text");
        label.setText(text);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        label.setFont(new Font("Monospaced", Font.BOLD, size));
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = x;
        gbc.gridy = y;
        window.add(label,gbc);
    }
    //create function for create a button 
    void CreateButton(int x, int y, int width , String text, ActionListener action){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton button = new JButton(text);
        //set size ,color and padding
        button.setPreferredSize(new Dimension(200, 50));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(action);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(button,gbc);
    }
    void ShowDisplay() {
        window.setVisible(true);
    }
    void Close() {
        window.dispose();
    }
    void HideControls() {
        window.setUndecorated(true);
    }
    void SetPosition(Point location) {
        window.setLocation(location.x,location.y);
    }

    void SetBGColor() {
        window.getContentPane().setBackground(Color.WHITE);
    }

    void ClearDisplay() {
        Component[] components = window.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton jbutton) {
	            window.remove(jbutton);
            } else if (component instanceof JLabel jlabel) {
                window.remove(jlabel);
            } else if (component instanceof JPanel jPanel) {
                window.remove(jPanel);
            }
        }
    }
    void UpdateDisplay() {
        window.revalidate();
        window.repaint();
    }
    void SetFullscreen() {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    Dimension GetWindowSize() {
        return window.getSize();
    }
    void AddPanel(Panel panel) {
        window.add(panel.GetPanel());
    }
}
