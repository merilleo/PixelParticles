package PixelParticles.utils.Image;

import java.awt.*;

import static PixelParticles.utils.Positions.getXFromIndex;
import static PixelParticles.utils.Positions.getYFromIndex;

public class Pixel implements PixelInterface {
    int index;
    int x;
    int y;
    Color col;
    float r;
    float g;
    float b;
    float a;

    public Pixel(int index, int width, Color col) {
        this.index = index;
        this.x = getXFromIndex(index, width);
        this.y = getYFromIndex(index, width);
        this.col = col;
        this.r   = col.getRed();
        this.g   = col.getGreen();
        this.b   = col.getBlue();
        this.a   = col.getAlpha();
    }

    public Pixel(PixelInterface pix, int width) {
        this.index = pix.getIndex();
        this.x = getXFromIndex(pix.getIndex(), width);
        this.y = getYFromIndex(pix.getIndex(), width);
        this.col = pix.getColor();
        this.r   = pix.getRed();
        this.g   = pix.getGreen();
        this.b   = pix.getBlue();
        this.a   = pix.getAlpha();
    }

    public void setIndex(int index) { this.index = index; }
    public void setX(int x)         { this.x = x; }
    public void setY(int y)         { this.y = y; }
    public void setColor(Color col) { this.col = col; }
    public void setRed(float r)     { this.r = r; }
    public void setGreen(float g)   { this.g = g; }
    public void setBlue(float b)    { this.b = b; }
    public void setAlpha(float a)   { this.a = a; }
    public void setRGBA(Color col) {
        this.r   = col.getRed();
        this.g   = col.getGreen();
        this.b   = col.getBlue();
        this.a   = col.getAlpha();
    }

    public int   getIndex() { return this.index ;}
    public int   getX()     { return this.x ;}
    public int   getY()     { return this.y ;}
    public Color getColor() { return this.col ;}
    public float getRed()   { return this.r ;}
    public float getGreen() { return this.g ;}
    public float getBlue()  { return this.b ;}
    public float getAlpha() { return this.a ;}
    public PixelInterface getClone(int width) { return new Pixel(this, width); }

}
