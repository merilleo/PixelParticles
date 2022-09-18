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

        Settings.forces.add(new RandomForce((float) 0.1));
        Settings.forces.add(new DragForce());

        Settings.drawingMethods.add(new DrawSquare(10));

        Settings.ps.addForceList(Settings.forces);
        Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
        Settings.ps.spawnNumberOfParticles(25, Settings.particle);
        Settings.ps.setRandomPositions();

        PixelInterface pixel = new Pixel(0, width, new Color(0, 0, 0));

        PImage pimage;
        Path path = Paths.get("PixelParticles/data/frau_02_a.jpg");
        pimage = loadImage(path.toAbsolutePath().toString());
        Settings.img01.importPImage(pimage, pixel);
    }

    public void draw(){
        Settings.ps.update();
        showFramerate();
    }

    public static void main(String[] args){
        String[] processingArgs = {"PixelParticles"};
        PApplet.runSketch(processingArgs, Settings.sketch);
    }
}
