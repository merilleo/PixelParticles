package PixelParticles.ParticleSystem;

import processing.core.PVector;
import java.awt.Color;
public interface ParticleInterface {
    void update();

    void addForce(PVector f);

    void setForce(PVector f);
    void setPosition(PVector p);
    void setVelocity(PVector v);
    void setAcceleration(PVector a);
    void setMass(float m);
    void setColor(Color col);
    void lerpColor(Color col, float smoothingFactor);


    ParticleInterface getClone();
    PVector getForce();
    PVector getPosition();
    float getX();
    float getY();
    PVector getVelocity();
    PVector getAcceleration();
    float getMass();
    Color getColor();
    int getRGB();
}
