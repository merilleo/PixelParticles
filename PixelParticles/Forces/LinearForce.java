package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public class LinearForce implements ForceInterface {
    public PVector direction;
    public float strength;
    public LinearForce(PVector direction, float strength) {
        this.direction = direction;
        this.strength = strength;
    }
    public PVector getForce(ParticleInterface particle) {
        return this.direction.copy().mult(this.strength);
    }
}
