package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import static processing.core.PApplet.pow;

public class DragForce implements ForceInterface {
    private float strength;

    public DragForce() {
        this.strength = 1.0F;
    }
    public PVector getForce(ParticleInterface particle) {
        float forceDrag = (float) (pow( particle.getVelocity().mag(), 2) *  0.03744 * this.strength);
        PVector drag = particle.getForce().copy();
        drag.normalize();
        drag.mult(-forceDrag);
        return drag;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }
}
