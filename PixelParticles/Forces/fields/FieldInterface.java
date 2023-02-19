package PixelParticles.Forces.fields;

import PixelParticles.Forces.ForceInterface;
import PixelParticles.Forces.fields.fieldObjects.FieldObjectInterface;
import processing.core.PApplet;

public interface FieldInterface extends ForceInterface {
    int getColumns();
    int getRows();
    float getCellWidth();
    float getCellHeight();
    FieldObjectInterface[] getCells();
    void populateField(FieldObjectInterface object);
    void bakeField(PApplet sketch);
}
