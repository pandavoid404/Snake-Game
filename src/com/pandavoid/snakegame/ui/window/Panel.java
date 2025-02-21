package com.pandavoid.snakegame.ui.window;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Panel {
	private final JPanel panel;
	private Image backgroundImage;

	Panel(int width, int height) {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setSize(new Dimension(width, height));
		panel.setLayout(new GridBagLayout());
	}
	JPanel GetPanel() {
		return panel;
	}

	void CreateLabel(String text , int size) {
		JLabel label = new JLabel(text);
		//add GridBagConstraints and add padding
		GridBagConstraints gbc = new GridBagConstraints();
		label.setFont(new Font("Monospaced", Font.BOLD, size));
		label.setForeground(Color.white);
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(label, gbc);
	}

	//create function for create a button
	void CreateButton(ActionListener action) {
		GridBagConstraints gbc = new GridBagConstraints();
		JButton button = new JButton("Change Color");
		//set size ,color and padding
		button.setPreferredSize(new Dimension(200, 50));
		button.setBackground(Color.white);
		button.setForeground(Color.black);
		button.setFocusPainted(false);
		button.addActionListener(action);
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(button, gbc);
	}
}