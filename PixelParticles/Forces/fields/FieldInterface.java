package PixelParticles.Forces.fields;

import PixelParticles.Forces.ForceInterface;
import PixelParticles.Forces.fields.fieldObjects.FieldObjectInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PApplet;

public interface FieldInterface extends ForceInterface {
    int getColumns();
    int getRows();
    float getCellWidth();
    float getCellHeight();
    FieldObjectInterface[] getCells();
    int getCellIndexFromParticlePosition(ParticleInterface particle);
    void populateField(FieldObjectInterface object);
    void bakeField(PApplet sketch);

}
