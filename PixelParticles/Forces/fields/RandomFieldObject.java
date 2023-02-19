package PixelParticles.Forces.fields;

import PixelParticles.ParticleSystem.Particle;

import java.util.Random;

import static java.lang.Math.random;
import static processing.core.PApplet.floor;

public class RandomFieldObject implements FieldObjectInterface {
    float randomNumber;

    public RandomFieldObject getClone() {
        return new RandomFieldObject();
    }
    public void generateNewValue() {
        this.randomNumber = (float) random();
    }
    public RandomFieldObject() {
        this.generateNewValue();
    }
    @Override
    public int getValue() {
        return floor(this.randomNumber * 255);
    }
}
