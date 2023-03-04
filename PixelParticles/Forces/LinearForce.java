package PixelParticles.Forces;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public class LinearForce implements ForceInterface {
    public PVector direction;
    public float strength;


    public static class LinearForceBuilder implements ForceBuilderInterface {
        private PVector direction;
        private float strength;

        public LinearForceBuilder() {
            // Set default values
            this.direction = new PVector(1, 0);
            this.strength = 1.0F;
        }
        public LinearForce.LinearForceBuilder direction(PVector direction) {
            this.direction = direction;
            return this;
        }

        public LinearForce.LinearForceBuilder strength(float strength) {
            this.strength = strength;
            return this;
        }

        public LinearForce build() {
            return new LinearForce(this);
        }
    }

    public LinearForce(PVector direction, float strength) {
        this.direction = direction;
        this.strength = strength;
    }

    public LinearForce(LinearForceBuilder linearForceBuilder) {
        this.direction = linearForceBuilder.direction;
        this.strength = linearForceBuilder.strength;
    }



    public PVector getForce(ParticleInterface particle) {
        return this.direction.copy().mult(this.strength);
    }
}
