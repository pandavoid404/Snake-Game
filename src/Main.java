
import java.awt.*;
import javax.swing.*;

public class Main {
    static short height = 700;
    static short width = 1000; 
    static JFrame frame = new JFrame("SnakeGame");
    public static void main(String[]args) {
        //set size and closing
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        createlabel( 0 ,  0 , "SnakeGame" );
        createbuton(0 , 1 , "StartGame" );
        createbuton(0,2,"settings" );
        createbuton( 0 , 3 , "Quit Game" );
    }
    public static  void createlabel(int gridx, int gridy ,String labeltext) {
        JLabel label=new JLabel(labeltext);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);  
        gbc.gridx = gridx;  
        gbc.gridy = gridy;  
        frame.add(label,gbc);
        frame.setVisible(true);
    }
    public static void createbuton(int gridx, int gridy ,String buttontext ){
        GridBagConstraints gbc = new GridBagConstraints();
        JButton createbuton = new JButton(buttontext);
        gbc.gridx = gridx;  
        gbc.gridy = gridy;
        createbuton.setSize (400, 400);
        frame.add(createbuton,gbc);
        frame.setVisible(true);
    }
} 