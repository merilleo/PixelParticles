package PixelParticles.Forces.fields.fieldObjects;

import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.utils.noises.Perlin;
import processing.core.PVector;

import static processing.core.PApplet.floor;

@Deprecated
// implement when precaluculated Vectorfield is first implemented
public class PerlinForceFieldObject implements ForceFieldObjectInterface {
    private int col;
    private int row;
    private float scale;
    private float strength;

    public PerlinForceFieldObject(float scale) {
        this.col = 0;
        this.row = 0;
        this.scale = scale;
    }
    public PerlinForceFieldObject(int column, int row, float strength) {
        this.col = column;
        this.row = row;
        this.strength = strength;
        this.scale = 0.5F;
    }
    public PerlinForceFieldObject(PerlinForceFieldObject perlinFieldObject) {
        this.col = perlinFieldObject.getColumn();
        this.row = perlinFieldObject.getRow();
        this.scale = perlinFieldObject.getScale();
    }

    public PerlinForceFieldObject getClone() {
        return new PerlinForceFieldObject(this);
    }


    public void setScale(float scale) {
        this.scale = scale;
    }
    public float getScale() {
        return this.scale;
    }

    @Override
    public PVector getForceVector(ParticleInterface particle) {
        int x = floor(Perlin.perlin(new PVector(this.col * this.scale, this.row * this.scale)) * 255);
        int y = floor(Perlin.perlin(new PVector(this.col * this.scale, this.row * this.scale)) * 255);
        return new PVector(x, y);
    }

    @Override
    public float getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(float strength) {
        this.strength = strength;
    }

//    TODO implement getClone
    @Override
    public ForceFieldObjectInterface getClone(int column, int row, float strength) {
        return null;
    }

    @Override
    public void printObject() {

    }

    @Override
    public void setColumn(int col) {
        this.col = col;
    }

    @Override
    public void setRow(int rows) {
        this.row = rows;
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
