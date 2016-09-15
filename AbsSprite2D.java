//-------------------------------------------------------------------
// Sprite2D: maintain states: locx, locy, width, height, color.
//-------------------------------------------------------------------
import java.awt.*;

abstract class AbsSprite2D extends AbsSprite {
    protected int locx;
    protected int locy;
    protected int spriteW;
    protected int spriteH;

    Color color;
    boolean fill;

    public void setLocx(int locx) {
        this.locx = locx;
    }

    public int getLocx() {
        return this.locx;
    }

    public void setLocy(int locy) {
        this.locy = locy;
    }

    public int getLocy() {
        return this.locy;
    }

    public void setSpriteW(int spriteW) {
        this.spriteW = spriteW;
    }

    public int getSpriteW() {
        return this.spriteW;
    }

    public void setSpriteH(int spriteH) {
        this.spriteH = spriteH;
    }

    public int getSpriteH() {
        return this.spriteH;
    }

    public void setFill(boolean b) {
        fill = b;
    }

    public boolean isFill() {
        return fill;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }
}

