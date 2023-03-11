package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import java.util.Random;

import static PixelParticles.utils.RandomUtils.random;

public class RandomForce implements ForceInterface {
    private float strength;
    private int seed;
    private Random rng;
    public RandomForce(float strength, int seed) {
        this.strength = strength;
        this.seed = seed;
        this.rng = new Random(seed);
    }
    public RandomForce() {
        this.strength = 1.0F;
        this.seed = 10;
        this.rng = new Random(seed);
    }
    public PVector getForce(ParticleInterface particle) {
        float x = (this.rng.nextFloat() - 0.5F) * 2;
        float y = (this.rng.nextFloat() - 0.5F) * 2;
        return new PVector(x, y).normalize().mult(this.strength);
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public Random getRng() {
        return rng;
    }

    public void setRng(Random rng) {
        this.rng = rng;
    }
}
