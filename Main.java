/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author David Rogers
 */
public class Main extends JFrame {
    GamePanel gamePanel;

    //This sets up the main component that is drawn on
    public Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("31");
        setSize(Consts.WIDTH + 6, Consts.HEIGHT + 39);
        setBackground(Color.GREEN);
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.initSprites();
        gamePanel.deal();
        gamePanel.setTokens();
        gamePanel.startGame();
        if(gamePanel.checkPlayerTotal() == 31){
            gamePanel.pauseGame();
            gamePanel.setWin1(true);
            gamePanel.changeTokens();
        }
        gamePanel.setFocusable(true);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
    }

}


