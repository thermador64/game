
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author  Chong-wei Xu
 */
public abstract class AbsGamePanel extends JPanel implements Runnable {

    private Thread animation = null;
    private boolean running = false;  // stops the animation
    volatile boolean gameOver = false;  // terminates the game
    private ArrayList<AbsSprite> spriteAry;
    protected Dimension d;

    /**
     * Creates new form AbsGamePanel
     */

    public AbsGamePanel() {
        super();
        initComponents();
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
        spriteAry = new ArrayList<AbsSprite>();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());

    }
    // </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public abstract void initSprites();

    public abstract void announceTermination(Graphics2D g2d);

    public abstract void pauseAnnouncement(Graphics2D g2d);


    public void startGame() {
        if (animation == null) {
            animation = new Thread(this);
            animation.start();
        }
    }

    public void run() {
        running = true;
        try {
            while (running) {
                repaint();
                updateGame(); 
                    Thread.sleep(80); // nano to ms
                
            }
        } catch (InterruptedException ex) {
        }
    }

    public void updateGame() {
        for (int i = 0; i < spriteAry.size(); i++) {
            ((AbsSprite) (spriteAry.get(i))).updateSprite();
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // clear the background
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, Consts.WIDTH, Consts.HEIGHT);

        // draw game elements by calling the abstract method
        for (int i = 0; i < spriteAry.size(); i++) {
            ((spriteAry.get(i))).paintSprite(g2d);
        }
        pauseAnnouncement(g2d);

        if (gameOver) {
            terminateGame(g2d);
        }
    }

    public void stopGame() {
        running = false;
    }

    public void pauseGame() {
        running = false;
    }

    public void resumeGame() {
        running = true;
    }



    public void terminateGame(Graphics2D g2d) {
        if (gameOver) {
            stopGame();
            announceTermination(g2d);
        }
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ArrayList getSpriteAry() {
        return spriteAry;
    }
}
