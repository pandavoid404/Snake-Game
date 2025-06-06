package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class Panel {
	private final JPanel panel;

	private Image backgroundImage;

	Panel(int width, int height) {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setSize(new Dimension(width, height));
		panel.setLayout(new GridBagLayout());
	}

	JPanel getPanel() {
		return panel;
	}

	public void setVisible(boolean b) {
		panel.setVisible(b);
	}

	Panel createPanel(int x , int y){
		Panel panel = new Panel(500, 700);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = x;
		gbc.gridy = y;
		this.panel.add(panel.getPanel(),gbc);
		return panel;
	}

	JLabel createLabel(String text , int size , int width , int y , int x) {
		JLabel label = new JLabel(text);
		//add GridBagConstraints and add padding
		GridBagConstraints gbc = new GridBagConstraints();
		label.setFont(new Font("Monospaced", Font.BOLD, size));
		label.setForeground(Color.white);
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		panel.add(label, gbc);
		return label;
	}

	//create function for create a button
	void createButton(ActionListener action, int x, int y, int width, int height, String text) {
		GridBagConstraints gbc = new GridBagConstraints();
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(width, height));
		button.setBackground(Color.white);
		button.setForeground(Color.black);
		button.setFocusPainted(false);
		button.addActionListener(action);
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		panel.add(button, gbc);
	}

	public void addSnakePaint(AssetPaint assetPaint) {
		panel.add(assetPaint);
	}
}