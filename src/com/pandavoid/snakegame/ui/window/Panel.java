package com.pandavoid.snakegame.ui.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panel {
	private JPanel panel;
	GridBagConstraints gbc;
	public Panel(int y , int x , int width , int height) {
		gbc = new GridBagConstraints();
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		gbc.gridx = x;
		gbc.gridy = y;
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(width, height));
	}
	JPanel CreatePanel(int y , int x , int width , int height ){
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel newPanel = new JPanel();
		newPanel.setBackground(Color.CYAN);
		gbc.gridx = x;
		gbc.gridy = y;
		newPanel.setLayout(new FlowLayout());
		newPanel.setPreferredSize(new Dimension(width, height));
		panel.add(newPanel,gbc);
		return newPanel;
	}
	JLabel CreateLabel(int x, int y, String text) {
		JLabel label = new JLabel(text);
		//add GridBagConstraints and add padding
		GridBagConstraints gbc = new GridBagConstraints();
		label.setFont(new Font("Monospaced", Font.BOLD, 80));
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
