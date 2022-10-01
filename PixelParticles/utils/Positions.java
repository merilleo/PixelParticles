package PixelParticles.utils;

import processing.core.PVector;

import static processing.core.PApplet.floor;

public class Positions {
    public static int getIndexFromXY(int x, int y, int width) {
        return ( x + y * width );
    }
    public static int getXFromIndex(int index, int width) {
        return ( index % width );
    }
    public static int getYFromIndex(int index, int width) {
        return ( floor( index * 1.0F / width) );
    }
    public static int getNearestX(float x) {
        return floor(x);
    }
    public static int getNearestY(float y) {
        return floor(y);
    }
    public static int getNearestIndex(float x, float y, int width) {
        return Positions.getIndexFromXY(floor(x), floor(y), width);
    }
    public static int getNearestIndexFromVector(PVector pos, int width) {
        return Positions.getIndexFromXY(floor(pos.x), floor(pos.y), width);
    }
}
