package PixelParticles.Forces.fields.fieldObjects;

import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PVector;

public interface ForceFieldObjectInterface {
    PVector getForceVector(ParticleInterface particle);
    void setColumn(int col);
    void setRow(int rows);
    int getColumn();
    int getRow();
    float getStrength();
    void setStrength(float strength);
    ForceFieldObjectInterface getClone(int column, int row, float strength);
    void printObject();

}
