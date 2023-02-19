package PixelParticles.ParticleSystem;

import PixelParticles.Draw.ColorRecalculators.ColorRecalculatorInterface;

import java.awt.*;

import static PixelParticles.utils.MathUtils.minMaxValue;
import static PixelParticles.utils.noises.Perlin.perlin;


public class PerlinColor implements ColorRecalculatorInterface {

    public Color getParticleColorFromImage(ParticleInterface particle) {
        float perlinValue = perlin(particle.getPosition());
        if (perlinValue > 0 ) { return new Color(255, 0, 0);}
        else if (perlinValue < 0) { return new Color(0,0, 255); }
        int br = (int) minMaxValue(perlinValue * 255, 0, 255);
        Color col = new Color(br, br, br);
        return col;
    }
}
