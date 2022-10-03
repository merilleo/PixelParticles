package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;
import static PixelParticles.utils.RandomUtils.random;

public class RandomForce implements ForceInterface{
    Float input;
    public RandomForce(float number) {
        this.input = number;
    }
    public PVector getForce(ParticleInterface particle) {
        return new PVector(random(-1, 1) * this.input, random(-1, 1) * this.input);
    }
}
