package PixelParticles.utils;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public class ScreenWrapper {
    int w;
    int h;
    int buffer;

    public ScreenWrapper(int w, int h) {
        this.w = w;
        this.h = h;
        this.buffer = 1;
    }

    private PVector getWrappedPosition(PVector p) {
        if (p.x < 0) {
            p.x = this.w - this.buffer;
        }
        if (p.x >= this.w) {
            p.x = this.buffer;
        }
        if (p.y < 0) {
            p.y = this.w - this.buffer;
        }
        if (p.y >= this.w) {
            p.y = this.buffer;
        }
        return p;
    }

    public PVector applyWrapping(PVector pos) {
        PVector  p = pos.copy();
        p = this.getWrappedPosition(p);
        return p;
    }

    public PVector applyWrapping(ParticleInterface particle) {
        PVector  p = particle.getPosition().copy();
        p = this.getWrappedPosition(p);
        return p;
    }

}