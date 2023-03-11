package PixelParticles;

import PixelParticles.Forces.ForceInterface;
import PixelParticles.Forces.LinearForce;
import PixelParticles.Forces.fields.fieldObjects.*;
import PixelParticles.Forces.tests.*;
import PixelParticles.ParticleSystem.*;
import PixelParticles.utils.Image.Image;
import processing.core.PVector;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public interface Settings {
    Main sketch = new Main();
    int width  = 1000;
    int height = 500;

    ArrayList<ParticleSystemInterface> particleSystemList = new ArrayList<ParticleSystemInterface>();



    ParticleSystem ps = new ParticleSystem.ParticleSystemBuilder(Settings.width, Settings.height)
//            .addLinearForce(15.0F, new PVector(1, 0))
//            .addForceField(10, 1, 10.0F, ForceFieldObjectType.random)
//            .addForceField(1000, 1000, 5.0F, ForceFieldObjectType.random)
//            .addForceField(ForceFieldObjectType.random.getForceFieldObject(1,1, 1.0F))
            .build();

//    ParticleSystem ps2 = new ParticleSystem.ParticleSystemBuilder(500, 100)
//            .addLinearForce(5.0F, new PVector(1, 2))
//            .build();


    Image img01 = new Image(Settings.width, Settings.height);
    Image img02 = new Image(Settings.width, Settings.height);

    Particle particle = new Particle();
//    ArrayList<ForceInterface> forces = new ArrayList<ForceInterface>();
//    ArrayList<DrawingMethodInterface> drawingMethods = new ArrayList<DrawingMethodInterface>();
//    ArrayList<ColorRecalculatorInterface> colorRecalculators = new ArrayList<ColorRecalculatorInterface>();

}
