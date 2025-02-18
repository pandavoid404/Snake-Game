
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    static short height = 700;
    static short width = 1000; 
    static JFrame frame = new JFrame("SnakeGame");
    public static void main(String[]args) {
        //exit and closing 
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        //call functions 
        create_label( 0 ,  0 , "SnakeGame" );
        createButton(0 , 10 , "StartGame",Color.BLACK, Color.WHITE,e -> System.out.println("Game Starting..."));
        createButton(0,20,"Settings" ,Color.BLACK, Color.WHITE,e -> System.out.println("settings"));
        createButton( 0 , 30 , "Credits",Color.BLACK, Color.WHITE ,e -> System.out.println("Credits"));
        createButton( 0 , 40 , "Quit Game",Color.BLACK, Color.WHITE ,e -> System.exit(0));
    }
    //create function for create a label for text
    public static  void create_label(int gridx, int gridy ,String label_text) {
        JLabel label = new JLabel(label_text);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = gridx;  
        gbc.gridy = gridy; 

        frame.add(label,gbc);
        frame.setVisible(true);
    }
    //create function for create a button 
    public static void createButton(int gridx, int gridy ,String buttontext , Color bgColor, Color textColor , ActionListener action){
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
        frame.add(create_button,gbc);
        frame.setVisible(true);
    }
} 