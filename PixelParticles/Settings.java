package PixelParticles;

import PixelParticles.Forces.UniformForceLibrary;
import PixelParticles.Forces.fields.ForceFieldLibrary;
import PixelParticles.ParticleSystem.*;
import PixelParticles.utils.Image.Image;
import PixelParticles.utils.Image.Pixel;
import PixelParticles.utils.Image.PixelInterface;
import processing.core.PImage;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public interface Settings {
    Main sketch = new Main();
    int width  = 1000;
    int height = 500;
    Image defaultImage = new Image(Settings.width, Settings.height);

    Image img01 = new Image(Settings.width, Settings.height);
    Image img02 = new Image(Settings.width, Settings.height);

    Particle particle = new Particle();
    ArrayList<ParticleSystemInterface> particleSystemList = new ArrayList<ParticleSystemInterface>();

    ParticleSystem ps = new ParticleSystem.ParticleSystemBuilder(Settings.width, Settings.height)
            .build();

//    ParticleSystem ps2 = new ParticleSystem.ParticleSystemBuilder(500, 100)
//            .addLinearForce(5.0F, new PVector(1, 2))
//            .build();




    public static void setSketchSettings() {
        Settings.sketch.size(Settings.width, Settings.height);
        Settings.sketch.smooth(8);
    }

    public static void setUniformForceSettings() {
        UniformForceLibrary.LinearForceSettings.direction   ( 1, 0 );
        UniformForceLibrary.LinearForceSettings.strength    ( 3.0F );

        UniformForceLibrary.RandomForceSettings.strength    ( 10.0F );

        UniformForceLibrary.DragForceSettings.strength      ( 2.0F );
    }
    public static void setForceFieldSettings() {
        ForceFieldLibrary.RandomFieldSettings.rows(10);
        ForceFieldLibrary.RandomFieldSettings.columns(5);
        ForceFieldLibrary.RandomFieldSettings.strength(1.5F);
        ForceFieldLibrary.RandomFieldSettings.width(Settings.width);
        ForceFieldLibrary.RandomFieldSettings.height(Settings.height);

        ForceFieldLibrary.PerlinFieldSettings.rows(100);
        ForceFieldLibrary.PerlinFieldSettings.columns(100);
        ForceFieldLibrary.PerlinFieldSettings.strength(1.5F);
        ForceFieldLibrary.PerlinFieldSettings.width(Settings.width);
        ForceFieldLibrary.PerlinFieldSettings.height(Settings.height);
    }

    public static void setImage(Image img, String filePath) {
        PixelInterface pixel = new Pixel(0, width, new Color(255, 0, 0, 0));
        PImage pimage;
        Path path = Paths.get(filePath);
        pimage = Settings.sketch.loadImage(path.toAbsolutePath().toString());
        pimage.resize(Settings.width, Settings.height);
        img.importPImage(pimage, pixel);
    }

}
