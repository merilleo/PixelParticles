package PixelParticles.Forces.fields.fieldObjects;

import processing.core.PVector;

public interface FieldObjectInterface extends CellInterface {
    int getValue();
    FieldObjectInterface getClone();

}
