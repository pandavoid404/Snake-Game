package com.pandavoid.snakegame.ui;

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

    Container getContentPane() {
        return window.getContentPane();
    }

    java.awt.Window getWindow() {
        return window;
    }

    Dimension getWindowSize() {
        return window.getSize();
    }

    void setFullscreen() {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    void setMainWindow() {
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setPosition(Point location) {
        window.setLocation(location.x,location.y);
    }

    void setBGColor() {
        window.getContentPane().setBackground(Color.WHITE);
    }

    Panel createPanel(int x , int y ,int gbcWidth){
        Panel panel = new Panel(x, y);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gbcWidth;
        window.add(panel.getPanel(),gbc);
        return panel;
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
    void createDropdown(String item1, String Item2, String item3, int x, int y, int gbcWidth,int width,int height){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        JComboBox<String> dropdown = new JComboBox<>();
        dropdown.addItem(item1);
        dropdown.addItem(Item2);
        dropdown.addItem(item3);
        dropdown.setPreferredSize(new Dimension(width, height));
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gbcWidth;
        window.add(dropdown,gbc);
    }

    void showDisplay() {
        window.setVisible(true);
    }

    void hideControls() {
        window.setUndecorated(true);
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
            }else if (component instanceof JComboBox JComboBox) {
                window.remove(JComboBox);
            }else if (component instanceof JSlider JSlider) {
                window.remove(JSlider);
            }else if (component instanceof JCheckBox JCheckBox) {
                window.remove(JCheckBox);
            }
        }
    }

    void updateDisplay() {
        window.revalidate();
        window.repaint();
    }

    void addPanel(JPanel panel) {
        window.add(panel);
    }

    void close() {
        window.dispose();
    }
}
