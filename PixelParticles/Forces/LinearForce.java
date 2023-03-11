package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public class LinearForce implements ForceInterface {
    public PVector direction;
    public float strength;

    public LinearForce() {
        this.direction = new PVector(1, 0);
        this.strength = 1.0F;
    }
    public LinearForce(PVector direction, float strength) {
        this.direction = direction;
        this.strength = strength;
    }

    public PVector getForce(ParticleInterface particle) {
        return this.direction.copy().mult(this.strength);
    }

    public PVector getDirection() {
        return direction;
    }

    public void setDirection(PVector direction) {
        this.direction = direction;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }
}
