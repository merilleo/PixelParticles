package PixelParticles.Forces.fields.fieldObjects;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import java.util.Random;

import static processing.core.PApplet.println;

public class RandomForceFieldObject implements ForceFieldObjectInterface {
   private int col;
   private int row;
   private float strength;
   private final int seed = 2765543;
   private float x;
   private float y;
   private Random rng;

    public RandomForceFieldObject() {
        this.setColumn(0);
        this.setRow(0);
        this.setStrength(1.0F);
        this.setRNG();
    }
    public RandomForceFieldObject(int column, int row, float strength) {
        this.setColumn(column);
        this.setRow(row);
        this.setStrength(strength);
        this.setRNG();
    }

    private void setRNG() {
        this.rng = new Random((long) ((this.col+1.0F) / (this.row+1.0F) * this.seed + 1.0F));
        this.x = this.strength * ((this.rng.nextFloat() - 0.5F) * 2.0F);
        this.y = this.strength * ((this.rng.nextFloat() * 2.0F) - 1.0F);
    }

    public void printObject() {
        println(this.col, this.row, this.strength, this.x, this.y, this.rng);
    }

    @Override
    public PVector getForceVector(ParticleInterface particle) {
        return new PVector(this.x, this.y);
    }

    @Override
    public ForceFieldObjectInterface getClone(int column, int row, float strength) {
        return new RandomForceFieldObject(column, row, strength);
    }

    @Override
    public float getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(float strength) {
        this.strength = strength;
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
