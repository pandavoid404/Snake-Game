package com.pandavoid.snakegame.ui.window;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window {
    private final JFrame window;
    Window(String title,int width,int height) {
        window = new JFrame(title);
        window.setSize(width,height);
        window.setLayout(new GridBagLayout());
    }
    void setMainWindow() {
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    Panel createPanel(int x , int y){
        Panel panel = new Panel(500, 700);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        window.add(panel.getPanel(),gbc);
        return panel;
    }
    Container getContentPane() {
        return window.getContentPane();
    }

    void createLabel(String text, int size, int x, int y, int gwidth) {
        JLabel label = new JLabel("text");
        label.setText(text);
        //add GridBagConstraints and add padding
        GridBagConstraints gbc = new GridBagConstraints();
        label.setFont(new Font("Monospaced", Font.BOLD, size));
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gwidth;
        window.add(label,gbc);
    }
    void createJTextArea(String text, int size, int x, int y, boolean editable, int top , int bottom , int boxwidth, int boxheight) {
        JTextArea textArea = new JTextArea("text",10,30);
        textArea.setText(text);
        //set GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        textArea.setFont(new Font("Monospaced", Font.BOLD, size));
        gbc.insets = new Insets(top, 0, bottom, 0);
        gbc.gridx = x;
        gbc.gridy = y;
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(editable);
        window.add(textArea,gbc);

    }
    //create function for create a button 
    void createButton(int x, int y, int width , String text, ActionListener action){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton button = new JButton(text);
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

    void showDisplay() {
        window.setVisible(true);
    }
    void close() {
        window.dispose();
    }
    void hideControls() {
        window.setUndecorated(true);
    }
    void setPosition(Point location) {
        window.setLocation(location.x,location.y);
    }

    void setBGColor() {
        window.getContentPane().setBackground(Color.WHITE);
    }

    void clearDisplay() {;
        Component[] components = window.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton jbutton) {
	            window.remove(jbutton);
            } else if (component instanceof JLabel jlabel) {
                window.remove(jlabel);
            } else if (component instanceof JPanel jPanel) {
                window.remove(jPanel);
            }else if (component instanceof  JTextArea JTextArea) {
                window.remove(JTextArea);
            }
        }
    }
    void updateDisplay() {
        window.revalidate();
        window.repaint();
    }
    void setFullscreen() {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    Dimension getWindowSize() {
        return window.getSize();
    }

    void addPanel(JPanel panel) {
        window.add(panel);
    }

    java.awt.Window getWindow() {
        return window;
    }
}
