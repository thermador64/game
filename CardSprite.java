
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David
 */
public class CardSprite extends AbsSprite2D {

    public BufferedImage[] cardImages;
    private int cardNum;
    private boolean isSelected;
    private AnIntMoveable motion;
    private int vx, vy;
    PropertyChangeSupport cardChange;

    public CardSprite() {
        cardImages = new BufferedImage[Consts.NUM_CARDIMAGES];
        setVisible(true);
        cardChange = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.cardChange.addPropertyChangeListener(listener);
    }

    public void initCardImages() {
        try {

            cardImages[0] = ImageIO.read(getClass().getResource("cards/b1fv.gif"));
            cardImages[1] = ImageIO.read(getClass().getResource("cards/s1.gif"));
            cardImages[2] = ImageIO.read(getClass().getResource("cards/sk.gif"));
            cardImages[3] = ImageIO.read(getClass().getResource("cards/sq.gif"));
            cardImages[4] = ImageIO.read(getClass().getResource("cards/sj.gif"));
            cardImages[5] = ImageIO.read(getClass().getResource("cards/s10.gif"));
            cardImages[6] = ImageIO.read(getClass().getResource("cards/s9.gif"));
            cardImages[7] = ImageIO.read(getClass().getResource("cards/s8.gif"));
            cardImages[8] = ImageIO.read(getClass().getResource("cards/s7.gif"));
            cardImages[9] = ImageIO.read(getClass().getResource("cards/s6.gif"));
            cardImages[10] = ImageIO.read(getClass().getResource("cards/s5.gif"));
            cardImages[11] = ImageIO.read(getClass().getResource("cards/s4.gif"));
            cardImages[12] = ImageIO.read(getClass().getResource("cards/s3.gif"));
            cardImages[13] = ImageIO.read(getClass().getResource("cards/s2.gif"));
            cardImages[14] = ImageIO.read(getClass().getResource("cards/h1.gif"));
            cardImages[15] = ImageIO.read(getClass().getResource("cards/hk.gif"));
            cardImages[16] = ImageIO.read(getClass().getResource("cards/hq.gif"));
            cardImages[17] = ImageIO.read(getClass().getResource("cards/hj.gif"));
            cardImages[18] = ImageIO.read(getClass().getResource("cards/h10.gif"));
            cardImages[19] = ImageIO.read(getClass().getResource("cards/h9.gif"));
            cardImages[20] = ImageIO.read(getClass().getResource("cards/h8.gif"));
            cardImages[21] = ImageIO.read(getClass().getResource("cards/h7.gif"));
            cardImages[22] = ImageIO.read(getClass().getResource("cards/h6.gif"));
            cardImages[23] = ImageIO.read(getClass().getResource("cards/h5.gif"));
            cardImages[24] = ImageIO.read(getClass().getResource("cards/h4.gif"));
            cardImages[25] = ImageIO.read(getClass().getResource("cards/h3.gif"));
            cardImages[26] = ImageIO.read(getClass().getResource("cards/h2.gif"));
            cardImages[27] = ImageIO.read(getClass().getResource("cards/d1.gif"));
            cardImages[28] = ImageIO.read(getClass().getResource("cards/dk.gif"));
            cardImages[29] = ImageIO.read(getClass().getResource("cards/dq.gif"));
            cardImages[30] = ImageIO.read(getClass().getResource("cards/dj.gif"));
            cardImages[31] = ImageIO.read(getClass().getResource("cards/d10.gif"));
            cardImages[32] = ImageIO.read(getClass().getResource("cards/d9.gif"));
            cardImages[33] = ImageIO.read(getClass().getResource("cards/d8.gif"));
            cardImages[34] = ImageIO.read(getClass().getResource("cards/d7.gif"));
            cardImages[35] = ImageIO.read(getClass().getResource("cards/d6.gif"));
            cardImages[36] = ImageIO.read(getClass().getResource("cards/d5.gif"));
            cardImages[37] = ImageIO.read(getClass().getResource("cards/d4.gif"));
            cardImages[38] = ImageIO.read(getClass().getResource("cards/d3.gif"));
            cardImages[39] = ImageIO.read(getClass().getResource("cards/d2.gif"));
            cardImages[40] = ImageIO.read(getClass().getResource("cards/c1.gif"));
            cardImages[41] = ImageIO.read(getClass().getResource("cards/ck.gif"));
            cardImages[42] = ImageIO.read(getClass().getResource("cards/cq.gif"));
            cardImages[43] = ImageIO.read(getClass().getResource("cards/cj.gif"));
            cardImages[44] = ImageIO.read(getClass().getResource("cards/c10.gif"));
            cardImages[45] = ImageIO.read(getClass().getResource("cards/c9.gif"));
            cardImages[46] = ImageIO.read(getClass().getResource("cards/c8.gif"));
            cardImages[47] = ImageIO.read(getClass().getResource("cards/c7.gif"));
            cardImages[48] = ImageIO.read(getClass().getResource("cards/c6.gif"));
            cardImages[49] = ImageIO.read(getClass().getResource("cards/c5.gif"));
            cardImages[50] = ImageIO.read(getClass().getResource("cards/c4.gif"));
            cardImages[51] = ImageIO.read(getClass().getResource("cards/c3.gif"));
            cardImages[52] = ImageIO.read(getClass().getResource("cards/c2.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCardNum(int num) {
        cardNum = num;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setSelected(boolean b) {
        isSelected = b;
    }

    public boolean getSelected() {
        return isSelected;
    }

    @Override
    void paintSprite(Graphics2D g2d) {
        if (isVisible()) {
            g2d.drawImage(cardImages[cardNum], locx, locy, null);
            if (isSelected) {
                g2d.setColor(Color.YELLOW);
                g2d.drawRect(locx, locy, 70, 95);

            }
        }
    }

    @Override
    void updateSprite() {
        motion.setPosition(getLocx(), getLocy());
        motion.setVelocity(getVx(), getVy());
        motion.updatePosition();
        setLocx(motion.getX());
        setLocy(motion.getY());
        setVx(motion.getVx());
        setVy(motion.getVy());
        if(getLocx() < (Consts.PLAYER2X + 70)){
            cardChange.firePropertyChange("player2Move", "value1", "value2");
        }
        if(getLocy() < (Consts.PLAYER3Y + 100)){
            cardChange.firePropertyChange("player3Move", "value1", "value2");
        }
        if(getLocx() > (Consts.PLAYER4X - 70)){
            cardChange.firePropertyChange("player4Move", "value1", "value2");
        }
    }

    public void setVx(int x) {
        vx = x;
    }

    public void setVy(int y) {
        vy = y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void initMotion(AnIntMoveable move) {
        motion = move;
        motion.setWidth(getSpriteW());
        motion.setHeight(getSpriteH());
        setVx(10);
        setVy(10);

    }
}
