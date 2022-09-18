package PixelParticles;

import PixelParticles.DrawingMethods.DrawSquare;
import PixelParticles.Forces.DragForce;
import PixelParticles.Forces.RandomForce;
import PixelParticles.Image.Pixel;
import PixelParticles.Image.PixelInterface;
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

        PixelInterface pixel = new Pixel(0, width, new Color(0, 0, 0));
        PImage pimage;
        Path path = Paths.get("PixelParticles/data/uv_checker large.png");
        pimage = loadImage(path.toAbsolutePath().toString());
        Settings.img01.importPImage(pimage, pixel);

        Settings.forces.add(new RandomForce((float) 0.1));
        Settings.forces.add(new DragForce());

        Settings.drawingMethods.add(new DrawSquare(5));

        Settings.ps.addForceList(Settings.forces);
        Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
        Settings.ps.spawnNumberOfParticles(25000, Settings.particle);
        Settings.ps.setRandomPositions();
        Settings.ps.setColorsFromImage(Settings.img01);

    }

    public void draw(){
        Settings.ps.update();
        Settings.ps.lerpColorFromImage(Settings.img01, 0.1F);
        showFramerate();
    }

    public static void main(String[] args){
        String[] processingArgs = {"PixelParticles"};
        PApplet.runSketch(processingArgs, Settings.sketch);
    }
}
