
/*
 * Moveable.java
 *
 * Created on August 5, 2006, 6:32 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Chong-wei Xu
 */
public interface AnIntMoveable {
    public void setPosition(int x, int y);
    public void setVelocity(int vx, int vy);
    public void updatePosition();
    public void setWidth(int width);
    public void setHeight(int height);
    public int getX();
    public int getY();
    public int getVx();
    public int getVy();
}
