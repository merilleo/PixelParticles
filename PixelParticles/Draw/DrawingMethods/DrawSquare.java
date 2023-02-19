package PixelParticles.Draw.DrawingMethods;

import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.Settings;

public class DrawSquare implements DrawingMethodInterface {
    float size;

    public DrawSquare(float size) {
        this.size = size;
    }

    public void drawParticle(ParticleInterface p) {
        Settings.sketch.noStroke();
        Settings.sketch.fill( p.getRGB() );
        Settings.sketch.rect( p.getX(), p.getY(), this.size, this.size );
    }
}
