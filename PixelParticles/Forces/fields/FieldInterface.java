package PixelParticles.Forces.fields;

import PixelParticles.Forces.ForceInterface;
import processing.core.PApplet;

public interface FieldInterface extends ForceInterface {
    void populateField(FieldObjectInterface object);
    void bakeField(PApplet sketch);
}
