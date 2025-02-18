import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class window {
    JFrame window;
    public window(String title) {
        window = new JFrame(title);
    }
        //create function for create a label for text
    public void create_label(int gridx, int gridy ,String label_text) {
        JLabel label = new JLabel(label_text);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = gridx;  
        gbc.gridy = gridy; 

        window.add(label,gbc);
        window.setVisible(true);
    }
    //create function for create a button 
    public void createButton(int gridx, int gridy ,String buttontext , Color bgColor, Color textColor , ActionListener action){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton create_button = new JButton(buttontext);
        //set size ,color and padding
        create_button.setPreferredSize(new Dimension(200, 50));
        create_button.setBackground(bgColor);
        create_button.setForeground(textColor);
        create_button.setFocusPainted(false);
        create_button.addActionListener(action);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = gridx;  
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        window.add(create_button,gbc);
        window.setVisible(true);
    }
}
