package PixelParticles.utils;

import static processing.core.PApplet.floor;

public class Positions {
    public static int getIndexFromXY(int x, int y, int width) {
        return ( x + y*width );
    }
    public static int getXFromIndex(int index, int width) {
        return ( index % width );
    }
    public static int getYFromIndex(int index, int width) {
        return ( floor(index / width) );
    }
    public static int getNearestX(float x) {
        return (int) floor(x);
    }
    public static int getNearestY(float y) {
        return (int) floor(y);
    }
    public static int getNearestIndex(float x, float y, int width) {
        return Positions.getIndexFromXY((int) floor(x), (int) floor(y), width);
    }
}
