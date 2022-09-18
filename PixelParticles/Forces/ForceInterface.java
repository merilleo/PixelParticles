package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public interface ForceInterface {
    PVector getForce(ParticleInterface particle);
}
