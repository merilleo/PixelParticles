package PixelParticles.ParticleSystem;

import processing.core.PVector;
import java.awt.Color;
public interface ParticleInterface {
    void update();

    void addForce(PVector f);

    void setForce(PVector f);
    void setPosition(PVector p);
    void setPrevPosition(PVector p);
    void setStartPosition();
    void setVelocity(PVector v);
    void setAcceleration(PVector a);
    void setMass(float m);
    void setColor(Color col);


    ParticleInterface getClone();
    PVector getForce();
    PVector getPosition();
    PVector getPrevPosition();
    PVector getStartPosition();
    float getX();
    float getY();
    float getPrevX();
    float getPrevY();
    PVector getVelocity();
    PVector getAcceleration();
    float getMass();
    Color getColor();
    int getRGB();
}
