
import java.awt.Graphics2D;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class TokenSprite extends AbsSprite2D{

    int numOfTokens;
    public TokenSprite(){
    }

    public void setTokens(int numOfTokens){
        this.numOfTokens = numOfTokens;
    }

    public int getTokens(){
        return numOfTokens;
    }

    public void decreaseTokens(){
        numOfTokens--;
    }

    @Override
    void paintSprite(Graphics2D g2d) {
        g2d.setColor(color);
        if(numOfTokens > 0){
            g2d.fillOval(locx, locy, 20, 20);
        }
        if(numOfTokens > 1){
            g2d.fillOval(locx + 25, locy, 20, 20);
        }
        if(numOfTokens > 2){
            g2d.fillOval(locx + 50, locy, 20, 20);
        }
        if(numOfTokens > 3){
            g2d.fillOval(locx + 75, locy, 20, 20);
        }

    }

    @Override
    void updateSprite() {

    }

}
