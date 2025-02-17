
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

        JLabel label=new JLabel();
        label.setText("Snake Game");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 500, 0);  
        gbc.gridx = 0;  
        gbc.gridy = 0;  

        JButton startgame = new JButton("StartGame");
        startgame.setBounds(0, 0, 100, 30);
        
        frame.add(label,gbc);
        frame.add(startgame);
        frame.setVisible(true);
    }
} 