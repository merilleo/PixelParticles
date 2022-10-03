package PixelParticles.utils.noises;

import PixelParticles.ParticleSystem.ColorRecalculatorInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import java.awt.*;

import static processing.core.PApplet.map;

public class ForceColor implements ColorRecalculatorInterface {


    public Color getParticleColorFromImage(ParticleInterface particle) {
        PVector force = particle.getForce();
        int r = (int) map(force.x,-1,1, 0, 255);
        int g = 0;
        int b = (int) map(force.y,-1,1, 0, 255);
        Color col = new Color(r, g, b);
        return col;
    }
}
