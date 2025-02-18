
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    static final short height = 700;
    static final short width = 1000; 
    static JFrame frame = new JFrame("SnakeGame");
    public static void main(String[]args) {
        //exit and closing 
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        //call functions 
        create_label( 0, 0, "SnakeGame");

        ActionListener quitAction = e -> quitGame();
        ActionListener CreditsAction = e -> Credits();
        ActionListener SettingsAction = e -> Settings();
        ActionListener StartGameAction = e -> StartGame();

        createButton(0 , 10 , "StartGame",Color.BLACK, Color.WHITE, StartGameAction);
        createButton(0,20,"Settings" ,Color.BLACK, Color.WHITE, SettingsAction);
        createButton( 0 , 30 , "Credits",Color.BLACK, Color.WHITE , CreditsAction);
        createButton( 0 , 40 , "Quit Game",Color.BLACK, Color.WHITE , quitAction);
    }
    private static void quitGame(){
        System.exit(0);
    }
    private static void Credits(){
        System.out.println("Credits");
    }
    private static void Settings(){
        System.out.println("settings");
    }
    private static void StartGame(){
        System.out.println("Game Starting...");
    }
} 