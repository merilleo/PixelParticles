package PixelParticles;

import PixelParticles.Draw.ColorRecalculators.VelocityColor;
import PixelParticles.Draw.DrawingMethods.DrawLine;
import PixelParticles.Forces.UniformForceLibrary;
import PixelParticles.ParticleSystem.ParticleSystemInterface;
import PixelParticles.utils.Image.Pixel;
import PixelParticles.utils.Image.PixelInterface;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Color;
import java.nio.file.Path;
import java.nio.file.Paths;

import static PixelParticles.Settings.particleSystemList;
import static PixelParticles.utils.SketchDebugUtils.*;


public class Main extends PApplet{

    public void settings() {

        Settings.sketch.size(Settings.width, Settings.height);
        Settings.sketch.smooth(8);
    }
    public void setup(){

        PixelInterface pixel = new Pixel(0, width, new Color(255, 0, 0, 0));
        PImage pimage;
        Path path = Paths.get("PixelParticles/data/black_1024x1024px.jpg");
        pimage = loadImage(path.toAbsolutePath().toString());
        Settings.img01.importPImage(pimage, pixel);

        PImage pimage2;
        Path path2 = Paths.get("PixelParticles/data/uv_checker large.png");
        pimage2 = loadImage(path2.toAbsolutePath().toString());
        Settings.img02.importPImage(pimage2, pixel);

//        Settings.ps.addForce(new RandomForce(8.1F));
//        Settings.ps.addForce(new LinearForce(new PVector(1,0), 5));
        //Settings.ps.addForce(new PerlinForce(1, 10F, 0.5F));
//        Settings.ps.addForce(new ValueNoise(1024/4, 1024/4));

//        RandomForceFieldObject randomFieldObject = new RandomForceFieldObject();
//        ForceField randomField = new ForceField(5.1F, 20,20, randomFieldObject, Settings.sketch);
//        Settings.ps.addForce(randomField);
//        PerlinForceFieldObject perlinFieldObject = new PerlinForceFieldObject(0.1F);
//        ForceField linearField = new ForceField(15.1F, 100,100, perlinFieldObject, Settings.sketch);
//        Settings.ps.addForce(linearField);
//        Settings.ps.addForce(new DragForce());

//        Settings.ps.addDrawingMethode(new DrawSquare(1));
//        Settings.ps.addDrawingMethode(new DrawLine(2));

//        Settings.ps.addColorRecalculator(new VelocityColor());
//        Settings.ps.addColorRecalculator(new LerpImageColor(Settings.img02, 0.1F));
//        Settings.ps.addColorRecalculator(new ImageColorWithAlpha(Settings.img02, 255));
//        Settings.ps.addColorRecalculator(new ConstantImageColorWithAlpha(Settings.img02, 100));
//        Settings.ps.addColorRecalculator(new PerlinColor());

        //Settings.ps.addForceList(Settings.forces);
        //Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
//        Settings.ps.spawnNumberOfParticles(1000, Settings.particle);
//        Settings.ps.setRandomPositions();
//        Settings.ps.setColorsFromImageWithAlpha(Settings.img02, 255);
//        Settings.sketch.image(pimage, 0, 0);


//        Settings.ps.spawnNumberOfParticles(1000, Settings.particle);
//        Settings.ps.setRandomPositions();

        particleSystemList.add(Settings.ps);
        UniformForceLibrary.LinearForceSettings.direction(1, 1);
        UniformForceLibrary.LinearForceSettings.strength(3.0F);
        UniformForceLibrary.RandomForceSettings.strength(10.0F);
        UniformForceLibrary.DragForceSettings.strength(2.0F);

        for (ParticleSystemInterface ps : particleSystemList) {
            ps.addDrawingMethode(new DrawLine(2));
            ps.addColorRecalculator(new VelocityColor());
            ps.spawnNumberOfParticles(1000, Settings.particle);
            ps.setRandomPositions();
            ps.addForce(UniformForceLibrary.LINEAR);
            ps.addForce(UniformForceLibrary.RANDOM);
            ps.addForce(UniformForceLibrary.DRAG);
        }
    }

    public void draw(){
        drawScreenRect(0, 5F);
//        Settings.ps.update();
//        Settings.ps.drawPS();
        for (ParticleSystemInterface ps : particleSystemList) {
            ps.update();
            ps.drawPS();
        }
        showFramerate();
    }

    public static void main(String[] args){
        String[] processingArgs = {"PixelParticles"};
        PApplet.runSketch(processingArgs, Settings.sketch);
    }
}
