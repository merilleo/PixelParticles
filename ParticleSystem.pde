import java.util.ArrayList;

interface AbstractParticleSystem {
    public void update();
    public void updateParticles();
    public void applyScreenWrapper();
    public void addParticle(AbstractParticle obj);
    public void addForce(AbstractForce force);
    public void addForceList(ArrayList<AbstractForce> forceList);
    public void addDrawingMethode(AbstractDrawingMethode drawingMethode);
    public void addDrawingMethodeList(ArrayList<AbstractDrawingMethode> drawingMethodeList);
    public void drawParticles();
    public void spawnNumberOfParticles(int num, AbstractParticle obj);
    public AbstractParticle getParticle(int index);
    public ArrayList<AbstractParticle> getParticleList();
    public void setRandomPositions();
    public int getLength();
    public void applyForceToAll(AbstractForce force);
}


class ParticleSystem implements AbstractParticleSystem {

    ArrayList<AbstractParticle> particles;
    ArrayList<AbstractForce> forces;
    ArrayList<AbstractDrawingMethode> drawingMethods;
    ScreenWrapper wrapper;


    ParticleSystem() {
        this.particles = new ArrayList<AbstractParticle>();
        this.forces = new ArrayList<AbstractForce>();
        this.drawingMethods = new ArrayList<AbstractDrawingMethode>();
        this.wrapper = new ScreenWrapper(width, height);
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

    public void addParticle(AbstractParticle particle) {
        this.particles.add(particle);
    }

    public void addForce(AbstractForce force) {
        this.forces.add(force);
    }

    public void addForceList(ArrayList<AbstractForce> forceList) {
        forceList.forEach( f -> this.addForce(f) );
    }

    public void addDrawingMethode(AbstractDrawingMethode drawingMethode) {
        this.drawingMethods.add(drawingMethode);
    }

    public void addDrawingMethodeList(ArrayList<AbstractDrawingMethode> drawingMethodeList) {
        drawingMethodeList.forEach( dm -> this.addDrawingMethode(dm) );
    }

    public void applyForces() {
        for (AbstractForce f : this.forces) {
            for (AbstractParticle p : this.particles) {
                p.addForce( f.getForce(p) );
            }
        }
    }

    public void drawParticles() {
        for (AbstractDrawingMethode dm : this.drawingMethods) {
            for (AbstractParticle p : this.particles) {
                dm.drawParticle(p);
            }
        }
    }

    public void spawnNumberOfParticles(int num, AbstractParticle particle) {
        for (int i = 0; i < num; i++) {
            this.addParticle(particle.getClone());
        }
    }

    public void setRandomPositions() {
        for (int i = 0; i < this.particles.size(); i++) {
            PVector pos = new PVector(random(width), random(height));
            this.getParticle(i).setPosition( pos );
        }
    }

    public AbstractParticle getParticle(int index) {
        return  this.particles.get(index);
    }

    public ArrayList<AbstractParticle> getParticleList() {
        return  this.particles;
    }

    public int getLength() {
        return  this.particles.size();
    }


    public void applyForceToAll(AbstractForce force) {
        this.particles.forEach(p -> p.addForce( force.getForce(p) ));
    }
}
