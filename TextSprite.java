
import java.awt.Font;
import java.awt.Graphics2D;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class TextSprite extends AbsSprite2D{

    String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    void paintSprite(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.drawString(name, locx, locy);
    }

    @Override
    void updateSprite() {

    }

}
