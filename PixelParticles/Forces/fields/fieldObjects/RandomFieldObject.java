package PixelParticles.Forces.fields.fieldObjects;

import java.util.Random;

import static java.lang.Math.random;
import static processing.core.PApplet.floor;

public class RandomFieldObject implements FieldObjectInterface {
   private int col;
   private int row;
   private float randomNumber;
   private Random rng;

    public RandomFieldObject() {
        this.col = 0;
        this.row = 0;
        this.rng = new Random();
        this.randomNumber = this.rng.nextFloat() ;
    }
    public RandomFieldObject(FieldObjectInterface fieldObject) {
        this.randomNumber = fieldObject.getValue();
    }

    private void updateRandomNumber() {
        this.rng = new Random();
        this.randomNumber = this.rng.nextFloat();
    }

    public RandomFieldObject getClone() {
        return new RandomFieldObject();
    }
    @Override
    public int getValue() {
        return floor(this.randomNumber * 255);
    }

    @Override
    public void setColumn(int col) {
        this.col = col;
        this.updateRandomNumber();
    }

    @Override
    public void setRow(int row) {
        this.row = row;
        this.updateRandomNumber();
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
