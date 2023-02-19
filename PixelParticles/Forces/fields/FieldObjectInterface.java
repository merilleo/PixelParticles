package PixelParticles.Forces.fields;

public interface FieldObjectInterface {
    int getValue();
    void generateNewValue();

    FieldObjectInterface getClone();
}
