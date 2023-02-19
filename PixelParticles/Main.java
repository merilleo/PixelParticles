package PixelParticles;

import PixelParticles.Draw.ColorRecalculators.ConstantImageColorWithAlpha;
import PixelParticles.Draw.DrawingMethods.DrawLine;
import PixelParticles.Forces.DragForce;
import PixelParticles.Forces.fields.LinearField;
import PixelParticles.Forces.fields.fieldObjects.PerlinFieldObject;
import PixelParticles.Forces.fields.fieldObjects.RandomFieldObject;
import PixelParticles.utils.Image.Pixel;
import PixelParticles.utils.Image.PixelInterface;
import PixelParticles.Draw.ColorRecalculators.LerpImageColor;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Color;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        //Settings.ps.addForce(new RandomForce((float) 0.1));
        //Settings.ps.addForce(new LinearForce(new PVector(1,0), 1));
        //Settings.ps.addForce(new PerlinForce(1, 10F, 0.5F));
        //Settings.ps.addForce(new ValueNoise(1024/4, 1024/4));

//        RandomFieldObject randomFieldObject = new RandomFieldObject();
//        LinearField linearField = new LinearField(0.1F, 20,20, randomFieldObject, Settings.sketch);
//        Settings.ps.addForce(linearField);
        PerlinFieldObject perlinFieldObject = new PerlinFieldObject(0.1F);
        LinearField linearField = new LinearField(0.5F, 50,50, perlinFieldObject, Settings.sketch);
        Settings.ps.addForce(linearField);
        Settings.ps.addForce(new DragForce());


//        Settings.ps.addDrawingMethode(new DrawSquare(1));
        Settings.ps.addDrawingMethode(new DrawLine(2));

//        Settings.ps.addColorRecalculator(new ForceColor());
//        Settings.ps.addColorRecalculator(new LerpImageColor(Settings.img02, 0.1F));
//        Settings.ps.addColorRecalculator(new ImageColorWithAlpha(Settings.img02, 255));
        Settings.ps.addColorRecalculator(new ConstantImageColorWithAlpha(Settings.img02, 100));
//        Settings.ps.addColorRecalculator(new PerlinColor());

        //Settings.ps.addForceList(Settings.forces);
        //Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
        Settings.ps.spawnNumberOfParticles(500, Settings.particle);
        Settings.ps.setRandomPositions();
        //Settings.ps.setColorsFromImageWithAlpha(Settings.img02, 255);
        Settings.sketch.image(pimage, 0, 0);

        showFieldValues(linearField);

    }

    public void draw(){
//        PerlinFieldObject perlinFieldObject = new PerlinFieldObject(0.1F);
//        LinearField linearField = new LinearField(0.5F, 50,50, perlinFieldObject, Settings.sketch);
//        showFieldValues(linearField);

        drawScreenRect(0, 10F);
        Settings.ps.update();
        Settings.ps.drawPS();
        showFramerate();
    }

    public static void main(String[] args){
        String[] processingArgs = {"PixelParticles"};
        PApplet.runSketch(processingArgs, Settings.sketch);
    }
}
