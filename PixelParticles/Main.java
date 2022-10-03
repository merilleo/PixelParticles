package PixelParticles;

import PixelParticles.DrawingMethods.DrawSquare;
import PixelParticles.Forces.DragForce;
import PixelParticles.Forces.LinearForce;
import PixelParticles.Forces.PerlinForce;
import PixelParticles.Forces.RandomForce;
import PixelParticles.Image.Pixel;
import PixelParticles.Image.PixelInterface;
import PixelParticles.ParticleSystem.LerpImageColor;
import PixelParticles.ParticleSystem.PerlinColor;
import PixelParticles.utils.noises.ForceColor;
import PixelParticles.utils.noises.ValueNoise;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

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
        Path path = Paths.get("PixelParticles/data/black_1024x1024px.jpg");
        pimage = loadImage(path.toAbsolutePath().toString());
        Settings.img01.importPImage(pimage, pixel);

        PImage pimage2;
        Path path2 = Paths.get("PixelParticles/data/uv_checker large.png");
        pimage2 = loadImage(path2.toAbsolutePath().toString());
        Settings.img02.importPImage(pimage2, pixel);

        //Settings.ps.addForce(new RandomForce((float) 0.1));
        Settings.ps.addForce(new LinearForce(new PVector(1,0), 1));
        //Settings.ps.addForce(new PerlinForce(1, 10F, 0.5F));
        //Settings.ps.addForce(new ValueNoise(1024/4, 1024/4));
        //Settings.ps.addForce(new DragForce());



        Settings.ps.addDrawingMethode(new DrawSquare(5));

        Settings.ps.addColorRecalculator(new ForceColor());
        //Settings.ps.addColorRecalculator(new LerpImageColor(Settings.img02, 0.5F));
        //Settings.ps.addColorRecalculator(new PerlinColor());


        //Settings.ps.addForceList(Settings.forces);
        //Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
        Settings.ps.spawnNumberOfParticles(5000, Settings.particle);
        Settings.ps.setRandomPositions();
        //Settings.ps.setColorsFromImageWithAlpha(Settings.img02, 255);
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
