
import java.awt.*;
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
        createlabel( 0 ,  0 , "SnakeGame" );
        createbuton(0 , 10 , "StartGame",Color.BLACK, Color.WHITE);
        createbuton(0,20,"Settings" ,Color.BLACK, Color.WHITE);
        createbuton( 0 , 30 , "Quit Game",Color.BLACK, Color.WHITE );
    }
    //create function for create a label for text
    public static  void createlabel(int gridx, int gridy ,String labeltext) {
        JLabel label=new JLabel(labeltext);
        //add GridBagConstraints and add padding 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = gridx;  
        gbc.gridy = gridy; 

        frame.add(label,gbc);
        frame.setVisible(true);
    }
    //create function for create a button 
    public static void createbuton(int gridx, int gridy ,String buttontext , Color bgColor, Color textColor ){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton createbuton = new JButton(buttontext);
        //set size , color and pading
        createbuton.setPreferredSize(new Dimension(200, 50));
        createbuton.setBackground(bgColor);
        createbuton.setForeground(textColor);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = gridx;  
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(createbuton,gbc);
        frame.setVisible(true);
    }
} 