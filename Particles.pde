
interface AbstractParticle {
    public void update();

    public void addForce(PVector f);

    public void setForce(PVector f);
    public void setPosition(PVector p);
    public void setVelocity(PVector v);
    public void setAcceleration(PVector a);
    public void setMass(float m);
    public void setColor(color col);


    public AbstractParticle getClone();
    public PVector getForce();
    public PVector getPosition();
    public float getX();
    public float getY();
    public PVector getVelocity();
    public PVector getAcceleration();
    public float getMass();
    public color getColor();

    //public PVector addAbstractForce(AbstractForce force, PVector vec, float strength);
}

// Basic Particle Class
class Particle implements AbstractParticle {
    private PVector p;
    private PVector v;
    private PVector a;
    private PVector f;
    private float m;
    private color col;

    Particle() {
        this.p = new PVector();
        this.v = new PVector();
        this.a = new PVector();
        this.f = new PVector();
        this.m = 1;
        this.col = color(0, 0, 0);
    }

    Particle(AbstractParticle particle) {
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

    public AbstractParticle getClone() {
        return new Particle(this);
    }

    public void addForce(PVector f) {
        this.f.add(f);
    }
    public void setForce(PVector f) {
        this.f = f;
    }
    public void setPosition(PVector p) {
        this.p = p;
    }
    public void setVelocity(PVector v) {
        this.v = v;
    }
    public void setAcceleration(PVector a) {
        this.a = a;
    }
    public void setMass(float m) {
        this.m = m;
    }
    public void setColor(color col) {
        this.col = col;
    }

    public PVector getForce() {
        return this.f.copy();
    }
    public PVector getPosition() {
        return this.p.copy();
    }
    public float   getX() {
        return this.p.copy().x;
    }
    public float   getY() {
        return this.p.copy().y;
    }
    public PVector getVelocity() {
        return this.v.copy();
    }
    public PVector getAcceleration() {
        return this.a.copy();
    }
    public float getMass() {
        return this.m;
    }
    public color getColor() {
        return this.col;
    }
}

class SpecialParticle extends Particle {
    String test;

    SpecialParticle() {
        this.test = "test";
    }
    SpecialParticle(AbstractParticle particle) {
        this.test = "test";
    }

    public AbstractParticle getClone() {
        return new SpecialParticle(this);
    }

    void printStatus() {
        println(this.test);
    }
}
