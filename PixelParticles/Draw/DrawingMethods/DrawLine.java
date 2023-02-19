package PixelParticles.Draw.DrawingMethods;

import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.Settings;

public class DrawLine implements DrawingMethodInterface {
    float size;

    public DrawLine(float size) {
        this.size = size;
    }

    public void drawParticle(ParticleInterface p) {
        Settings.sketch.noFill();
        Settings.sketch.strokeWeight(this.size);
        Settings.sketch.stroke( p.getRGB() );
        Settings.sketch.line( p.getPrevX(), p.getPrevY(), p.getX(), p.getY() );
    }
}
