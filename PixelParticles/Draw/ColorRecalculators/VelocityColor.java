package PixelParticles.Draw.ColorRecalculators;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import java.awt.*;

import static processing.core.PApplet.map;
import static processing.core.PApplet.println;

public class VelocityColor implements ColorRecalculatorInterface {


    public Color getParticleColorFromImage(ParticleInterface particle) {
        PVector velocity = particle.getVelocity();
        int r = (int) map(velocity.x,-5,5, 0, 255);
        int g = 0;
        int b = (int) map(velocity.y,-5,5, 0, 255);
        if      (r <= 0)   { r = 0; }
        else if (r >= 255) { r = 255; }
        if      (b <= 0)   { b = 0; }
        else if (b >= 255) { b = 255; }
        return new Color(r, g, b);
    }
}
