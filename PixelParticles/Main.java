package PixelParticles;

import PixelParticles.Draw.ColorRecalculators.ColorRecalculatorLibrary;
import PixelParticles.Draw.DrawingMethods.DrawLine;
import PixelParticles.Forces.fields.ForceFieldLibrary;
import PixelParticles.ParticleSystem.ParticleSystemInterface;
import processing.core.PApplet;

import static PixelParticles.Settings.particleSystemList;
import static PixelParticles.utils.SketchDebugUtils.*;


public class Main extends PApplet{

    public void settings() {
        Settings.setSketchSettings();
        Settings.setUniformForceSettings();
        Settings.setForceFieldSettings();
    }

    public void setup(){

//        RandomForceFieldObject randomFieldObject = new RandomForceFieldObject();
//        ForceField randomField = new ForceField(5.1F, 20,20, randomFieldObject, Settings.sketch);
//        PerlinForceFieldObject perlinFieldObject = new PerlinForceFieldObject(0.1F);
//        ForceField linearField = new ForceField(15.1F, 100,100, perlinFieldObject, Settings.sketch);

//        Settings.ps.addDrawingMethode(new DrawSquare(1));
//        Settings.ps.addDrawingMethode(new DrawLine(2));

//        Settings.ps.addColorRecalculator(new PerlinColor());

        //Settings.ps.addDrawingMethodeList(Settings.drawingMethods);
//        Settings.ps.spawnNumberOfParticles(1000, Settings.particle);
//        Settings.ps.setRandomPositions();
//        Settings.sketch.image(pimage, 0, 0);


        Settings.ps.spawnNumberOfParticles(1000, Settings.particle);
//        Settings.ps.setRandomPositions();

        // Because Processing - Images have to be set in setup() !!!
        Settings.setImage(Settings.img01, "PixelParticles/data/uv_texture_1024x1024.jpg");
        Settings.setImage(Settings.img02, "PixelParticles/data/uv_texture_1024x1024.jpg");

        ColorRecalculatorLibrary.ChangingImageColorSettings.image(Settings.img02);
        ColorRecalculatorLibrary.ChangingImageColorSettings.alpha(255);
        ColorRecalculatorLibrary.ConstantImageColorSettings.image(Settings.img02);
        ColorRecalculatorLibrary.ConstantImageColorSettings.alpha(0);

        particleSystemList.add(Settings.ps);

        for (ParticleSystemInterface ps : particleSystemList) {
//            ps.addForce(UniformForceLibrary.LINEAR);
//            ps.addForce(UniformForceLibrary.RANDOM);
//            ps.addForce(UniformForceLibrary.DRAG);
            ps.addForce(ForceFieldLibrary.RANDOM_FIELD);
            ps.addColorRecalculator(ColorRecalculatorLibrary.VELOCITY);
//            ps.addColorRecalculator(ColorRecalculatorLibrary.CHANGING_IMAGE);
//            ps.addColorRecalculator(ColorRecalculatorLibrary.CONSTANT_IMAGE);
            ps.addDrawingMethode(new DrawLine(2));
            ps.spawnNumberOfParticles(1000, Settings.particle);
            ps.setRandomPositions();
        }
    }

    public void draw(){
        drawScreenRect(0, 5F);
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
