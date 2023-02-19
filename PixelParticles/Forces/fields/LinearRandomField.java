package PixelParticles.Forces.fields;

import PixelParticles.Forces.ForceInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.utils.ScreenWrapper;
import processing.core.PApplet;
import processing.core.PVector;

import static PixelParticles.utils.Positions.getNearestIndex;
import static PixelParticles.utils.Positions.getNearestIndexFromVector;
import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;

public class LinearRandomField implements FieldInterface{
    float strength;
    int columns;
    int rows;
    float cellWidth;
    float cellHeight;
    ScreenWrapper sketchWrapper;
    FieldObjectInterface[] cells;
    FieldObjectInterface[] bakedCells;

    public LinearRandomField(float strength, int columns, int rows, FieldObjectInterface object, PApplet sketch) {
        this.strength = strength;
        this.columns = columns;
        this.rows = rows;
        this.cellWidth = sketch.width / (float)this.columns;
        this.cellHeight = sketch.height / (float)this.rows;
        this.sketchWrapper = new ScreenWrapper(sketch.width, sketch.height, 0);
        this.cells = new FieldObjectInterface[this.columns * this.rows];
        this.populateField(object);
    }

    @Override
    public PVector getForce(ParticleInterface particle) {
        PVector cellPosition = particle.getPosition();
        this.sketchWrapper.applyWrapping(cellPosition);
        cellPosition.x /= this.cellWidth;
        cellPosition.y /= this.cellHeight;
        int index = getNearestIndexFromVector(cellPosition, this.columns );
        float angle = map(this.cells[index].getValue(), 0, 255, 0, TWO_PI);
        return PVector.fromAngle(angle).mult(this.strength);
    }

    @Override
    public void populateField(FieldObjectInterface object) {
        for (int i = 0; i < this.cells.length; i++) {
            object.generateNewValue();
            this.cells[i] = object.getClone();
        }
    }

    @Override
    public void bakeField(PApplet sketch) {
    }
}
