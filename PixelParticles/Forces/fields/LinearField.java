package PixelParticles.Forces.fields;

import PixelParticles.Forces.fields.fieldObjects.FieldObjectInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.utils.ScreenWrapper;
import processing.core.PApplet;
import processing.core.PVector;

import static PixelParticles.utils.Positions.*;
import static processing.core.PApplet.*;

public class LinearField implements FieldInterface{
    float strength;
    int columns;
    int rows;
    float cellWidth;
    float cellHeight;
    ScreenWrapper sketchWrapper;
    FieldObjectInterface[] cells;
    FieldObjectInterface[] bakedCells;

    public LinearField(float strength, int columns, int rows, FieldObjectInterface object, PApplet sketch) {
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
        int cellIndex = this.getCellIndexFromParticlePosition(particle);
        int cellValue = this.cells[cellIndex].getValue();
        float angle = map(cellValue, 0, 255, 0, TWO_PI);
        return PVector.fromAngle(angle).mult(this.strength);
    }

    @Override
    public int getCellIndexFromParticlePosition(ParticleInterface particle) {
        PVector cellPosition = particle.getPosition();
        cellPosition = this.sketchWrapper.applyWrapping(cellPosition);
        cellPosition.x /= this.cellWidth;
        cellPosition.y /= this.cellHeight;
        return getNearestIndexFromVector(cellPosition, this.columns );
    }

    @Override
    public void populateField(FieldObjectInterface object) {
        for (int i = 0; i < this.cells.length; i++) {
            this.cells[i] = object.getClone();
            this.cells[i].setColumn(getXFromIndex(i, this.rows));
            this.cells[i].setRow(getYFromIndex(i, this.rows));
//            println(this.cells[i].getColumn(), this.cells[i].getRow(), this.cells[i].getValue());
        }
    }

    @Override
    public void bakeField(PApplet sketch) {
    }

    @Override
    public int getColumns() {
        return this.columns;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public float getCellWidth() {
        return this.cellWidth;
    }

    @Override
    public float getCellHeight() {
        return this.cellHeight;
    }

    @Override
    public FieldObjectInterface[] getCells() {
        return this.cells;
    }

}
