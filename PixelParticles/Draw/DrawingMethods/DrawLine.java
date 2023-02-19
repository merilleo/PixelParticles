package PixelParticles.Draw.DrawingMethods;

import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.Settings;

import static java.lang.Math.abs;

public class DrawLine implements DrawingMethodInterface {
    float size;

    public DrawLine(float size) {
        this.size = size;
    }

    public void drawParticle(ParticleInterface p) {
        if(abs(p.getPrevX() - p.getX()) < Settings.sketch.width * 0.5 &&
           abs(p.getPrevY() - p.getY()) < Settings.sketch.height * 0.5 ) {
            Settings.sketch.noFill();
            Settings.sketch.strokeWeight(this.size);
            Settings.sketch.stroke( p.getRGB() );
            Settings.sketch.line( p.getPrevX(), p.getPrevY(), p.getX(), p.getY() );
        }
    }
}
