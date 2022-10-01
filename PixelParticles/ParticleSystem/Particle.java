package PixelParticles.ParticleSystem;

import processing.core.PVector;
import java.awt.*;


public class Particle implements ParticleInterface {
    private PVector p;
    private PVector v;
    private PVector a;
    private PVector f;
    private float m;
    private Color col;

    public Particle() {
        this.p = new PVector();
        this.v = new PVector();
        this.a = new PVector();
        this.f = new PVector();
        this.m = 1;
        this.col = new Color(0, 0, 0, 0);
    }

    Particle(ParticleInterface particle) {
        this.p =   particle.getPosition();
        this.v =   particle.getVelocity();
        this.a =   particle.getAcceleration();
        this.f =   particle.getForce();
        this.m =   particle.getMass();
        this.col = particle.getColor();
    }

    public void update() {
        this.a = this.f.div(this.m);
        this.v.add(this.a);
        this.p.add(this.v);
        this.a = new PVector();
        this.f = new PVector();
    }

    public void addForce(PVector f) { this.f.add(f); }

    public void setForce(PVector f)        { this.f = f; }
    public void setPosition(PVector p)     { this.p = p; }
    public void setVelocity(PVector v)     { this.v = v; }
    public void setAcceleration(PVector a) { this.a = a; }
    public void setMass(float m)           { this.m = m; }
    public void setColor(Color col)        { this.col = col; }



    public Particle getClone()        { return new Particle(this); }
    public PVector  getForce()        { return this.f.copy(); }
    public PVector  getPosition()     { return this.p.copy(); }
    public float    getX()            { return this.p.copy().x; }
    public float    getY()            { return this.p.copy().y; }
    public PVector  getVelocity()     { return this.v.copy(); }
    public PVector  getAcceleration() { return this.a.copy(); }
    public float    getMass()         { return this.m; }
    public Color    getColor()        { return this.col; }
    public int      getRGB()          { return this.col.getRGB(); }
}
