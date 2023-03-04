package PixelParticles;

import PixelParticles.Draw.DrawingMethods.DrawingMethodInterface;
import PixelParticles.Forces.ForceInterface;
import PixelParticles.ParticleSystem.*;
import PixelParticles.utils.Image.Image;
import PixelParticles.Draw.ColorRecalculators.ColorRecalculatorInterface;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Random;

public interface Settings {
    Main sketch = new Main();
    int width  = 1000;
    int height = 500;
    Random rngGenerator = new Random(1024);

    ParticleSystem ps = new ParticleSystem.ParticleSystemBuilder()
            .width(1000)
            .height(500)
            .addLinearForce(5.0F, new PVector(2, 1))
            .build();

    Image img01 = new Image(Settings.width, Settings.height);
    Image img02 = new Image(Settings.width, Settings.height);

    Particle particle = new Particle();
    ArrayList<ForceInterface> forces = new ArrayList<ForceInterface>();
    ArrayList<DrawingMethodInterface> drawingMethods = new ArrayList<DrawingMethodInterface>();
    ArrayList<ColorRecalculatorInterface> colorRecalculators = new ArrayList<ColorRecalculatorInterface>();

}
