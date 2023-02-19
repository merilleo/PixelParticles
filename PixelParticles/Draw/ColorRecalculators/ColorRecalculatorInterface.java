package PixelParticles.Draw.ColorRecalculators;

import PixelParticles.ParticleSystem.ParticleInterface;

import java.awt.*;

public interface ColorRecalculatorInterface {
    Color getParticleColorFromImage(ParticleInterface p);
}
