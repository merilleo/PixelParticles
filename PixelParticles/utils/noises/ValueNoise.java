package PixelParticles.utils.noises;

import PixelParticles.Forces.ForceInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
import PixelParticles.Settings;
import PixelParticles.utils.ScreenWrapper;
import processing.core.PVector;

import static PixelParticles.utils.MathUtils.multiplyTwoVectors;
import static PixelParticles.utils.Positions.*;
import static java.lang.Math.round;
import static processing.core.PApplet.*;

public class ValueNoise implements ForceInterface {
    private final float cellWidth;
    private final float cellHeight;
    private final int columns;
    private final int rows;
    private final float[] gridValues;
    private final float maxDist;
    private final ScreenWrapper cellWrapper;
    private final ScreenWrapper absoluteWrapper;

    public ValueNoise(float cellWidth, float cellHeight) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.columns = ceil(Settings.sketch.width / cellWidth);
        this.rows = ceil(Settings.sketch.height / cellHeight);
        this.maxDist = (float) Math.sqrt(  Math.pow(this.cellWidth, 2) + Math.pow(this.cellHeight, 2) );
        this.cellWrapper = new ScreenWrapper(this.columns, this.rows, 0);
        this.absoluteWrapper = new ScreenWrapper(Settings.width, Settings.height, 0);
        this.gridValues = new float[this.columns*this.rows];
        generateGridValues();
    }

    private void generateGridValues() {
        for (int i = 0; i < this.columns*this.rows; i++) {
            this.gridValues[i] = (float) Math.random();
        }
    }


    private float getNormalizedDistanceToCell(int cellIndex, PVector pos) {
        PVector cellPosition = multiplyTwoVectors(getCellPositionFromIndex(cellIndex), new PVector(this.cellWidth, this.cellHeight) );
        return PVector.dist(cellPosition, pos) / this.maxDist;

    }

    private PVector getCellPositionFromAbsolute(PVector pos) {
        int cellX = round((pos.x / this.cellWidth));
        int cellY = round((pos.y / this.cellHeight));
        return cellWrapper.applyWrapping( new PVector(cellX, cellY) );
    }
    private PVector getCellPositionFromIndex(int index) {
        float cellX = getXFromIndex(index, this.columns);
        float cellY = getYFromIndex(index, this.rows);
        return cellWrapper.applyWrapping( new PVector(cellX, cellY) );
    }

    private float getValue(PVector pos) {
        float value = 0;
        PVector cellPosition = getCellPositionFromAbsolute(pos);
        int index = getIndexFromXY((int)cellPosition.x, (int)cellPosition.y, this.columns);
        for (int y = (int)cellPosition.y -1; y < (int)cellPosition.y + 1; y+=2) {
            for (int x = (int)cellPosition.x -1; x < (int)cellPosition.x + 1; x+=2) {
                PVector tmpCell = cellWrapper.applyWrapping(new PVector(x, y));
                int tmpIndex = getIndexFromXY((int)tmpCell.x, (int)tmpCell.y, this.columns);
                float tmpValue = getNormalizedDistanceToCell(tmpIndex, pos);
                tmpValue *= this.gridValues[tmpIndex];
                value += tmpValue;
            }
        }
        return value / 4;
    }

    @Override
    public PVector getForce(ParticleInterface particle) {
        PVector offsetPosition = particle.getPosition();
        offsetPosition.add(new PVector(349898.F, 45544.673F));
        this.absoluteWrapper.applyWrapping(offsetPosition);
        float xNoise = getValue(particle.getPosition());
        float yNoise = getValue(offsetPosition);
        return new PVector(xNoise, yNoise);
    }
}
