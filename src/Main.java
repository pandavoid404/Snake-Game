
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    static JLabel label1;
    static short height = 700;
    static short width = 1000; 
    static JFrame frame = new JFrame("SnakeGame");
    public static void main(String[]args) {
        //set size and closing
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label=new JLabel();
        label.setText("hello world");
        label.setLocation(100,10);
        frame.add(label);
    }
} 