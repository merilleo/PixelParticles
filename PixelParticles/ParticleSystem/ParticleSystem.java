package PixelParticles.ParticleSystem;

import PixelParticles.DrawingMethods.DrawingMethodInterface;
import PixelParticles.Forces.ForceInterface;
import PixelParticles.Image.Image;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;
import PixelParticles.Settings;
import PixelParticles.utils.ScreenWrapper;

import static PixelParticles.utils.ColorUtils.convertToTransparentColor;
import static PixelParticles.utils.Positions.getNearestIndexFromVector;
import static PixelParticles.utils.RandomUtils.random;

public class ParticleSystem {
    ArrayList<ParticleInterface> particles;
    ArrayList<ForceInterface> forces;
    ArrayList<DrawingMethodInterface> drawingMethods;
    ArrayList<ColorRecalculatorInterface> colorRecalculators;
    ScreenWrapper wrapper;


    public ParticleSystem() {
        this.particles = new ArrayList<ParticleInterface>();
        this.forces = new ArrayList<ForceInterface>();
        this.drawingMethods = new ArrayList<DrawingMethodInterface>();
        this.colorRecalculators = new ArrayList<ColorRecalculatorInterface>();
        this.wrapper = new ScreenWrapper(Settings.width, Settings.height, 1);
    }

    public void update() {
        this.applyForces();
        this.updateParticles();
        this.applyScreenWrapper();
    }
    public void drawPS() {
        this.recalculateColors();
        this.drawParticles();
    }

    public void updateParticles() {
        this.particles.forEach(ParticleInterface::update);
    }
    public void updateParticlesStartPosition() { this.particles.forEach(ParticleInterface::setStartPosition); }

    public void applyScreenWrapper() {
        for (ParticleInterface p : this.particles) {
            p.setPosition( this.wrapper.applyWrapping(p) );
            p.setPrevPosition( this.wrapper.applyWrapping(p.getPrevPosition()) );
        }
    }

    public void addParticle(ParticleInterface particle) {
        this.particles.add(particle);
    }

    public void addForce(ForceInterface force) {
        this.forces.add(force);
    }

    public void addForceList(ArrayList<ForceInterface> forceList) {
        forceList.forEach(this::addForce);
    }

    public void addDrawingMethode(DrawingMethodInterface drawingMethode) {
        this.drawingMethods.add(drawingMethode);
    }

    public void addDrawingMethodeList(ArrayList<DrawingMethodInterface> drawingMethodeList) {
        drawingMethodeList.forEach(this::addDrawingMethode);
    }

    public void addColorRecalculator(ColorRecalculatorInterface colorRecalculator) {
        this.colorRecalculators.add(colorRecalculator);
    }

    public void addColorRecalculatorList(ArrayList<ColorRecalculatorInterface> colorRecalculatorList) {
        colorRecalculators.forEach( colorRecalculator -> this.addColorRecalculator(colorRecalculator) );
    }

    public void applyForces() {
        for (ForceInterface f : this.forces) {
            for (ParticleInterface p : this.particles) {
                p.addForce( f.getForce(p) );
            }
        }
    }

    public void drawParticles() {
        for (DrawingMethodInterface dm : this.drawingMethods) {
            for (ParticleInterface p : this.particles) {
                dm.drawParticle(p);
            }
        }
    }

    public void recalculateColors() {
        for (ColorRecalculatorInterface recalculator : this.colorRecalculators) {
            for (ParticleInterface p : this.particles) {
                Color col = recalculator.getParticleColorFromImage(p);
                p.setColor(col);
            }

        }
    }

    public void spawnNumberOfParticles(int num, ParticleInterface particle) {
        for (int i = 0; i < num; i++) {
            this.addParticle(particle.getClone());
        }
    }

    public void setRandomPositions() {
        for (int i = 0; i < this.particles.size(); i++) {
            PVector pos = new PVector(random(Settings.width), random(Settings.height));
            this.getParticle(i).setPosition( pos );
            this.getParticle(i).setStartPosition();
        }
    }

    public ParticleInterface getParticle(int index) {
        return  this.particles.get(index);
    }

    public ArrayList<ParticleInterface> getParticleList() {
        return  this.particles;
    }

    public int getLength() {
        return  this.particles.size();
    }


    public void applyForceToAll(ForceInterface force) {
        this.particles.forEach(p -> p.addForce( force.getForce(p) ));
    }

    public void setColorsFromImage(Image img) {
        for (ParticleInterface p : this.particles) {
            int index = getNearestIndexFromVector( p.getPosition(), img.getWidth() );
            Color col = img.getPixel(index).getColor();
            p.setColor(col);
        }
    }
    public void setColorsFromImageWithAlpha(Image img,int alpha) {
        for (ParticleInterface p : this.particles) {
            int index = getNearestIndexFromVector( p.getPosition(), img.getWidth() );
            Color col = img.getPixel(index).getColor();
            p.setColor(convertToTransparentColor(col, alpha));
        }
    }
}
