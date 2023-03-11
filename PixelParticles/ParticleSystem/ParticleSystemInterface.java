package PixelParticles.ParticleSystem;

import PixelParticles.Draw.ColorRecalculators.ColorRecalculatorInterface;
import PixelParticles.Draw.DrawingMethods.DrawingMethodInterface;
import PixelParticles.Forces.ForceInterface;
import PixelParticles.utils.Image.Image;

import java.util.ArrayList;

public interface ParticleSystemInterface {
    void update();
    void updateParticles();
    void applyScreenWrapper();
    void addParticle(ParticleInterface obj);
    void addParticleList(ArrayList<ParticleInterface> obj);
    void addForce(ForceInterface force);

    void addForceList(ArrayList<ForceInterface> forceList);

    void addDrawingMethode(DrawingMethodInterface drawingMethode);
    void addDrawingMethodeList(ArrayList<DrawingMethodInterface> drawingMethodeList);
    void addColorRecalculator(ColorRecalculatorInterface colorRecalculator);
    void addColorRecalculatorList(ArrayList<ColorRecalculatorInterface> colorRecalculatorList);
    void drawParticles();
    void spawnNumberOfParticles(int num, ParticleInterface obj);
    ParticleInterface getParticle(int index);
    ArrayList<ParticleInterface> getParticleList();
    void setRandomPositions();
    int getLength();
    void applyForceToAll(ParticleInterface force);
    void setColorsFromImage(Image img);

    void drawPS();
}
