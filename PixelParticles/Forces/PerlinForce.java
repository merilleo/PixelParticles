package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

import static PixelParticles.utils.noises.Perlin.perlin;

@Deprecated
public class PerlinForce implements ForceInterface{
    private Integer detail;
    private Float scale;
    private Float strength;

    public PerlinForce(int detail, float scale, float strength) {
        this.detail = detail;
        this.scale = scale * 10F;
        this.strength = strength;
    }


    public PVector getForce(ParticleInterface particle) {
        /*
        Settings.sketch.noiseDetail(this.detail);
        float xNoise = Settings.sketch.noise(particle.getX() / this.scale);
        xNoise = (xNoise * 2) - 0.5F; // Perlin Noise has a wierd range!
        xNoise *= this.strength;
        float yNoise = Settings.sketch.noise(particle.getY() / this.scale);
        yNoise = (yNoise * 2) - 0.5F;
        yNoise *= this.strength;
        return new PVector(xNoise, yNoise);
         */
        return new PVector( perlin(particle.getPosition()) * this.strength, perlin(particle.getPosition().add(new PVector(1000.36F, 894635.3492F))) * this.strength );
    }
}
