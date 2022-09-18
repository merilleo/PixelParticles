package PixelParticles.ParticleSystem;

import PixelParticles.DrawingMethods.DrawingMethodInterface;
import PixelParticles.Forces.ForceInterface;
import processing.core.PVector;
import java.util.ArrayList;
import PixelParticles.Settings;
import PixelParticles.utils.ScreenWrapper;
import static PixelParticles.utils.Random.random;

public class ParticleSystem {
    ArrayList<ParticleInterface> particles;
    ArrayList<ForceInterface> forces;
    ArrayList<DrawingMethodInterface> drawingMethods;
    ScreenWrapper wrapper;


    public ParticleSystem() {
        this.particles = new ArrayList<ParticleInterface>();
        this.forces = new ArrayList<ForceInterface>();
        this.drawingMethods = new ArrayList<DrawingMethodInterface>();
        this.wrapper = new ScreenWrapper(Settings.width, Settings.height);
    }

    public void update() {
        this.applyForces();
        this.updateParticles();
        this.applyScreenWrapper();
        this.drawParticles();
    }

    public void updateParticles() {
        this.particles.forEach(p -> p.update());
    }

    public void applyScreenWrapper() {
        this.particles.forEach(p -> p.setPosition( this.wrapper.applyWrapping(p) ));
    }

    public void addParticle(ParticleInterface particle) {
        this.particles.add(particle);
    }

    public void addForce(ForceInterface force) {
        this.forces.add(force);
    }

    public void addForceList(ArrayList<ForceInterface> forceList) {
        forceList.forEach( f -> this.addForce(f) );
    }

    public void addDrawingMethode(DrawingMethodInterface drawingMethode) {
        this.drawingMethods.add(drawingMethode);
    }

    public void addDrawingMethodeList(ArrayList<DrawingMethodInterface> drawingMethodeList) {
        drawingMethodeList.forEach( dm -> this.addDrawingMethode(dm) );
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

    public void spawnNumberOfParticles(int num, ParticleInterface particle) {
        for (int i = 0; i < num; i++) {
            this.addParticle(particle.getClone());
        }
    }

    public void setRandomPositions() {
        for (int i = 0; i < this.particles.size(); i++) {
            PVector pos = new PVector(random(Settings.width), random(Settings.height));
            this.getParticle(i).setPosition( pos );
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
}
