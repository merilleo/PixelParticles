package PixelParticles.Forces.fields;

import PixelParticles.Forces.ForceInterface;
import PixelParticles.Forces.fields.fieldObjects.ForceFieldObjectInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
import processing.core.PApplet;

public interface FieldInterface extends ForceInterface {
    int getColumns();
    void setColumns(int columns);
    int getRows();
    void setRows(int rows);
    int getWidth();
    void setWidth(int width);
    int getHeight();
    void setHeight(int height);
    float getStrength();
    void setStrength(float strength);
    float getCellWidth();
    float getCellHeight();
    void setBaseFieldObject(ForceFieldObjectInterface object);
    ForceFieldObjectInterface getBaseFieldObject();
    ForceFieldObjectInterface[] getCells();
    int getCellIndexFromParticlePosition(ParticleInterface particle);
    void populateField(ForceFieldObjectInterface object);
    void bakeField(PApplet sketch);

}
