package com.pandavoid.snakegame.ui.window;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class Panel {
	private final JPanel panel;
	Panel(int width, int height) {
	    panel = new JPanel();
        panel.setBackground(Color.BLACK);
		panel.setSize(new Dimension(width, height));
	}
	JPanel GetPanel(){
		return panel;
	}
	JLabel CreateLabel(int x, int y, String text ,int size,Color textColor ) {
		JLabel label = new JLabel(text);
		//add GridBagConstraints and add padding
		GridBagConstraints gbc = new GridBagConstraints();
		label.setFont(new Font("Monospaced", Font.BOLD, size));
		label.setForeground(textColor);
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(label,gbc);
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
		panel.add(button,gbc);
		return button;
	}
}
