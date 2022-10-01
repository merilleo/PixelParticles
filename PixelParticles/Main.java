package PixelParticles;

import PixelParticles.DrawingMethods.DrawSquare;
import PixelParticles.Forces.DragForce;
import PixelParticles.Forces.RandomForce;
import PixelParticles.Image.Pixel;
import PixelParticles.Image.PixelInterface;
import PixelParticles.ParticleSystem.LerpImageColor;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Color;
import java.nio.file.Path;
import java.nio.file.Paths;

import static PixelParticles.utils.SketchDebugUtils.showFramerate;


public class Main extends PApplet{

    public void settings() {
        Settings.sketch.size(Settings.width, Settings.height);
    }
    public void setup(){

        PixelInterface pixel = new Pixel(0, width, new Color(255, 0, 0, 0));
        PImage pimage;
        Path path = Paths.get("PixelParticles/data/HalfBW_1024x1024.jpg");
        pimage = loadImage(path.toAbsolutePath().toString());
        Settings.img01.importPImage(pimage, pixel);

        PImage pimage2;
        Path path2 = Paths.get("PixelParticles/data/uv_checker large.png");
        pimage2 = loadImage(path2.toAbsolutePath().toString());
        Settings.img02.importPImage(pimage2, pixel);

        Settings.ps.addForce(new RandomForce((float) 0.1));
        Settings.ps.addForce(new DragForce());

        Settings.ps.addDrawingMethode(new DrawSquare(1));

        Settings.ps.addColorRecalculator(new LerpImageColor(Settings.img02, 0.01F));

        //Settings.ps.addForceList(Settings.forces);
        //Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
        Settings.ps.spawnNumberOfParticles(5000, Settings.particle);
        Settings.ps.setRandomPositions();
        Settings.ps.setColorsFromImageWithAlpha(Settings.img02, 255);
        Settings.sketch.image(pimage, 0, 0);

    }

    public void draw(){
        Settings.ps.update();
        Settings.ps.drawPS();
        showFramerate();
    }

    public static void main(String[] args){
        String[] processingArgs = {"PixelParticles"};
        PApplet.runSketch(processingArgs, Settings.sketch);
    }
}
