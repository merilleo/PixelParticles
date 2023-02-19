package PixelParticles.ParticleSystem;

import PixelParticles.Draw.DrawingMethods.DrawingMethodInterface;
import PixelParticles.utils.Image.Image;

import java.util.ArrayList;

public interface ParticleSystemInterface {
    void update();
    void updateParticles();
    void applyScreenWrapper();
    void addParticle(ParticleInterface obj);
    void addForce(ParticleInterface force);
    void addForceList(ArrayList<ParticleInterface> forceList);
    void addDrawingMethode(DrawingMethodInterface drawingMethode);
    void addDrawingMethodeList(ArrayList<DrawingMethodInterface> drawingMethodeList);
    void drawParticles();
    void spawnNumberOfParticles(int num, ParticleInterface obj);
    ParticleInterface getParticle(int index);
    ArrayList<ParticleInterface> getParticleList();
    void setRandomPositions();
    int getLength();
    void applyForceToAll(ParticleInterface force);
    void setColorsFromImage(Image img);
}
