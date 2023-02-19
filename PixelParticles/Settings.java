package PixelParticles;

import PixelParticles.Draw.DrawingMethods.DrawingMethodInterface;
import PixelParticles.Forces.ForceInterface;
import PixelParticles.utils.Image.Image;
import PixelParticles.Draw.ColorRecalculators.ColorRecalculatorInterface;
import PixelParticles.ParticleSystem.Particle;
import PixelParticles.ParticleSystem.ParticleSystem;

import java.util.ArrayList;
import java.util.Random;

public interface Settings {
    Main sketch = new Main();
    int height = 1024;
    int width  = 1024;
    Random rngGenerator = new Random(1024);

    ParticleSystem ps = new ParticleSystem();
    Image img01 = new Image(Settings.width, Settings.height);
    Image img02 = new Image(Settings.width, Settings.height);

    Particle particle = new Particle();
    ArrayList<ForceInterface> forces = new ArrayList<ForceInterface>();
    ArrayList<DrawingMethodInterface> drawingMethods = new ArrayList<DrawingMethodInterface>();
    ArrayList<ColorRecalculatorInterface> colorRecalculators = new ArrayList<ColorRecalculatorInterface>();

}
