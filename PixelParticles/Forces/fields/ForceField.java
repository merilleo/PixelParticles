package PixelParticles.Forces.fields;

import PixelParticles.Forces.fields.fieldObjects.*;
import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.utils.ScreenWrapper;
import processing.core.PApplet;
import processing.core.PVector;

import static PixelParticles.utils.Positions.*;
import static processing.core.PApplet.println;

public class ForceField implements FieldInterface {
    float strength;
    int columns;
    int rows;
    int width;
    int height;
    ForceFieldObjectInterface fieldObject;
    float cellWidth;
    float cellHeight;
    ScreenWrapper screenWrapper;
    ForceFieldObjectInterface[] cells;
    ForceFieldObjectInterface[] bakedCells;




    public ForceField(int columns, int rows, int width, int height, float strength, ForceFieldObjectInterface object) {
        this.columns = columns;
        this.rows = rows;
        this.strength = strength;
        this.width = width;
        this.height = height;
        this.fieldObject = object;
        this.cellWidth = width / (float) this.columns;
        this.cellHeight = height / (float) this.rows;
        this.screenWrapper = new ScreenWrapper(width, height, 0);
        this.cells = new ForceFieldObjectInterface[this.columns * this.rows];
        this.populateField(object);
    }

    private void applyChanges(int columns, int rows, int width, int height, float strength, ForceFieldObjectInterface object) {
        this.columns = columns;
        this.rows = rows;
        this.strength = strength;
        this.width = width;
        this.height = height;
        this.fieldObject = object;
        this.cellWidth = width / (float) this.columns;
        this.cellHeight = height / (float) this.rows;
        this.screenWrapper = new ScreenWrapper(width, height, 0);
        this.cells = new ForceFieldObjectInterface[this.columns * this.rows];
        this.populateField(object);
    }

    @Override
    public PVector getForce(ParticleInterface particle) {
        int cellIndex = this.getCellIndexFromParticlePosition(particle);
        PVector cellValue = this.cells[cellIndex].getForceVector(particle);
        return cellValue.copy().mult(this.strength);
    }

    @Override
    public int getCellIndexFromParticlePosition(ParticleInterface particle) {
        PVector cellPosition = particle.getPosition();
        cellPosition = this.screenWrapper.applyWrapping(cellPosition);
        cellPosition.x /= this.cellWidth;
        cellPosition.y /= this.cellHeight;
        return getNearestIndexFromVector(cellPosition, this.columns );
    }

    @Override
    public void populateField(ForceFieldObjectInterface object) {
        for (int i = 0; i < this.cells.length; i++) {
            int column = getXFromIndex(i, this.rows);
            int row = getYFromIndex(i, this.rows);
            this.cells[i] = object.getClone(column, row, this.strength);
//            this.cells[i].printObject();
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
    public void setColumns(int columns) {
        this.applyChanges(columns, this.rows, this.width, this.height, this.strength, this.fieldObject);
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public void setRows(int rows) {
        this.applyChanges(this.columns, rows, this.width, this.height, this.strength, this.fieldObject);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int width) {
        this.applyChanges(this.columns, this.rows, width, this.height, this.strength, this.fieldObject);
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.applyChanges(this.columns, this.rows, this.width, height, this.strength, this.fieldObject);
        this.cellHeight = height / (float) this.rows;
        this.height = height;
    }

    @Override
    public float getStrength() {
        return strength;
    }

    @Override
    public void setStrength(float strength) {
        this.applyChanges(this.columns, this.rows, this.width, this.height, strength, this.fieldObject);
        this.strength = strength;
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
    public void setBaseFieldObject(ForceFieldObjectInterface object) {
        this.applyChanges(this.columns, this.rows, this.width, this.height, this.strength, object);
        this.fieldObject = object;
        this.populateField(object);
    }

    @Override
    public ForceFieldObjectInterface getBaseFieldObject() {
        return this.fieldObject;
    }

    @Override
    public ForceFieldObjectInterface[] getCells() {
        return this.cells;
    }

}
