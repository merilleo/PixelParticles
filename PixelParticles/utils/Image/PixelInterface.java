package PixelParticles.utils.Image;

import java.awt.Color;

public interface PixelInterface {
    void setIndex(int index);
    void setX(int x);
    void setY(int y);
    void setColor(Color col);
    void setRGBA (Color col);
    void setRed(float r);
    void setGreen(float g);
    void setBlue(float b);
    void setAlpha(float  a);

    int getIndex();
    int getX();
    int getY();
    Color getColor();
    float getRed();
    float getGreen();
    float getBlue();
    float getAlpha();
    PixelInterface getClone(int width);
}
