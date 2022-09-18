package PixelParticles;

import PixelParticles.DrawingMethods.DrawingMethodInterface;
import PixelParticles.Forces.ForceInterface;
import PixelParticles.Image.Image;
import PixelParticles.ParticleSystem.Particle;
import PixelParticles.ParticleSystem.ParticleSystem;

import java.util.ArrayList;

public interface Settings {
    Main sketch = new Main();
    int height = 1024;
    int width  = 1024;


    ParticleSystem ps = new ParticleSystem();
    Image img01 = new Image(Settings.width, Settings.height);

    Particle particle = new Particle();
    ArrayList<ForceInterface> forces = new ArrayList<ForceInterface>();

    ArrayList<DrawingMethodInterface> drawingMethods = new ArrayList<DrawingMethodInterface>();

}
