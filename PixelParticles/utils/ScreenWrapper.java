package PixelParticles.utils;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public class ScreenWrapper {
    int w;
    int h;
    int buffer;

    public ScreenWrapper(int w, int h, int buffer) {
        this.w = w;
        this.h = h;
        this.buffer = buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    private PVector getWrappedPosition(PVector p) {
        if (p.x < 0) {
            p.x = this.w - this.buffer;
        }
        if (p.x > this.w) {
            p.x = this.buffer;
        }
        if (p.y < 0) {
            p.y = this.h - this.buffer;
        }
        if (p.y > this.h) {
            p.y = this.buffer;
        }
        return p;
    }
    public boolean detectWrapping(PVector p) {
        boolean hasBeenWrapped = false;

        if (p.x < 0) {
            hasBeenWrapped = true;
        }
        if (p.x >= this.w) {
            hasBeenWrapped = true;
        }
        if (p.y < 0) {
            hasBeenWrapped = true;
        }
        if (p.y >= this.h) {
            hasBeenWrapped = true;
        }
        return hasBeenWrapped;
    }

    public PVector applyWrapping(PVector pos) {
        return this.getWrappedPosition( pos.copy() );
    }

    public PVector applyWrapping(ParticleInterface particle) {
        return this.getWrappedPosition( particle.getPosition().copy() );
    }

}