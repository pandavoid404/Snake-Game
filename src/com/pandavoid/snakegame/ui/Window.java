package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Window {
    private final JFrame window;
    private JComboBox dropdown;
    Window(String title,int width,int height) {
        window = new JFrame(title);
        window.setSize(width,height);
        window.setLayout(new GridBagLayout());
    }
    Container getContentPane() {
        return window.getContentPane();
    }
    public JComboBox getDropdown() {
        return dropdown;
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

    JLabel createLabel(String text, int size, int x, int y, int gwidth) {
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
        return label;
    }

    JTextArea createJTextArea(String text, int size, int x, int y, boolean editable, int top , int bottom , int boxwidth, int boxheight) {
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
        return textArea;
    }
    //create function for create a button 
    JButton createButton(int x, int y, int width , String text, ActionListener action){
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
        return button;
    }
    public JToggleButton createToggleButton(int x, int y, int width,String textOn, String textOff) {
        JToggleButton toggleButton = new JToggleButton(textOff);
        GridBagConstraints gbc = new GridBagConstraints();
        toggleButton.setPreferredSize(new Dimension(100, 50));
        toggleButton.setBackground(Color.BLACK);
        toggleButton.setForeground(Color.WHITE);
        toggleButton.setFocusPainted(false);
        toggleButton.setActionCommand(textOn);
        toggleButton.addActionListener(e -> {
            if (toggleButton.isSelected()) {
                toggleButton.setText(textOn);
            } else {
                toggleButton.setText(textOff);
            }
        });
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(toggleButton,gbc);
        return toggleButton;
    }
    JComboBox<String> createDropdown(ArrayList<String> items, int x, int y, int gbcWidth, int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        JComboBox<String> dropdown = new JComboBox<String>();
        for (String item : items) {
            dropdown.addItem(item);
        }
        dropdown.setPreferredSize(new Dimension(width, height));
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gbcWidth;
        window.add(dropdown,gbc);
        return dropdown;
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
            }else if (component instanceof JToggleButton toggleButton) {
                window.remove(toggleButton);
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
