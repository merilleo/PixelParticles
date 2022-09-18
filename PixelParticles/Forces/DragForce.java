package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import static processing.core.PApplet.pow;

public class DragForce implements ForceInterface {
    public PVector getForce(ParticleInterface particle) {
        float forceDrag = (float) (pow( particle.getVelocity().mag(), 2) *  0.03744);
        PVector drag = particle.getForce().copy();
        drag.normalize();
        drag.mult(-forceDrag);
        return drag;
    }
}
