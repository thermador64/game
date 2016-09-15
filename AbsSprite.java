
//-------------------------------------------------------------------
// Sprite.java -- An abstract class that defines all sprites.
//
// Sprites are objects.  The responsibilities is to paint themselves.
// (We have move the update function to the motion hierarchy).
//-------------------------------------------------------------------
import java.awt.*;

abstract class AbsSprite {
    protected boolean visible; // is sprite visible
    protected boolean active;  // is sprite updatable
    public Dimension d;

    // abstract methods:
    abstract void paintSprite(Graphics2D g2d);
    abstract void updateSprite();

    public void setDimension(Dimension d) {
        this.d = d;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean b) {
        visible = b;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean b) {
        active = b;
    }

    // suspend the sprite
    public void suspend() {
        setVisible(false);
        setActive(false);
    }

    // restore the sprite
    public void restore() {
        setVisible(true);
        setActive(true);
    }
}

