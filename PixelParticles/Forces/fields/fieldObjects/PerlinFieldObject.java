package PixelParticles.Forces.fields.fieldObjects;

import PixelParticles.utils.noises.Perlin;
import processing.core.PVector;

import static java.lang.Math.random;
import static processing.core.PApplet.floor;

public class PerlinFieldObject implements FieldObjectInterface {
    private int col;
    private int row;
    private float scale;

    public PerlinFieldObject(float scale) {
        this.col = 0;
        this.row = 0;
        this.scale = scale;
    }
    public PerlinFieldObject(PerlinFieldObject perlinFieldObject) {
        this.col = perlinFieldObject.getColumn();
        this.row = perlinFieldObject.getRow();
        this.scale = perlinFieldObject.getScale();
    }

    public PerlinFieldObject getClone() {
        return new PerlinFieldObject(this);
    }


    public void setScale(float scale) {
        this.scale = scale;
    }
    public float getScale() {
        return this.scale;
    }

    @Override
    public int getValue() {
        return floor(Perlin.perlin(new PVector(this.col * this.scale, this.row * this.scale)) * 255);
    }

    @Override
    public void setColumn(int col) {
        this.col = col;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getColumn() {
        return this.col;
    }

    @Override
    public int getRow() {
        return this.row;
    }
}
