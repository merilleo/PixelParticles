
interface AbstractForce {
    public PVector getForce(AbstractParticle particle);
}

class BaseForceInput {
    public float number;

    public BaseForceInput(float number) {
        this.number = number;
    }
}

class VecFloatForceInput {
    public PVector vector;
    public float number;

    public VecFloatForceInput(PVector vec, float number) {
        this.vector = vec.copy();
        this.number = number;
    }
}



class RandomForce implements AbstractForce {
    Float input;
    RandomForce(float number) {
        this.input = number;
    }
    PVector getForce(AbstractParticle particle) {
        return new PVector(random(-1, 1) * this.input, random(-1, 1) * this.input);
    }
}

class LinearForce implements AbstractForce {
    VecFloatForceInput inputs;
    LinearForce(PVector vec, float number) {
        this.inputs = new VecFloatForceInput(vec, number);
    }
    PVector getForce(AbstractParticle particle) {
        return this.inputs.vector.copy().mult(this.inputs.number);
    }
}

class DragForce implements AbstractForce {
    PVector getForce(AbstractParticle  particle) {
        float forceDrag = pow(particle.getVelocity().mag(), 2) *  0.03744;
        PVector drag = particle.getForce().copy(); // vecB = vecA -> vecB  points to A and changes to A get coppied into B. USE .copy()!!!
        drag.normalize();
        drag.mult(-forceDrag);
        return drag;
    }
}






class Forces {

    /* --------- Linear --------- */

    PVector linearForce(float mass, float x, float y) {
        return new PVector(x, y).div(mass);
    }
    PVector linearForce(AbstractParticle particle, float x, float y) {
        return new PVector(x, y).div(particle.getMass());
    }
    PVector linearForce(float mass, float x, float y, float strength) {
        return new PVector(x, y).normalize().mult(strength).div(mass);
    }
    PVector linearForce(float mass, PVector direction) {
        PVector fLinear  =  direction.copy();
        return fLinear.div(mass);
    }
    PVector linearForce(float mass, PVector direction, float strength) {
        PVector fLinear  =  direction.copy();
        return fLinear.normalize().mult(strength).div(mass);
    }


    /* --------- Random --------- */

    PVector randomForce(float strength) {
        return new PVector(random(-1, 1) * strength, random(-1, 1) * strength);
    }
    PVector randomForce(float x, float y) {
        return new PVector( x * random(-1, 1), y * random(-1, 1));
    }
    PVector randomUnitVector() {
        return new PVector( random(-1, 1), random(-1, 1)).normalize();
    }
    PVector randomFixedStrength(float strength) {
        return new PVector( random(-1, 1), random(-1, 1)).normalize().mult(strength);
    }


    /* --------- Wave --------- */

    PVector waveForce(PVector p, float scaleX, float scaleY, float strength) {
        return new PVector( strength * sin(scaleX * p.x), strength * cos(scaleY * p.y) );
    }
    PVector waveForce(PVector p, float scaleX, float scaleY, float strengthX, float strengthY) {
        return new PVector( strengthX * sin(scaleX * p.x), strengthY * cos(scaleY * p.y) );
    }
    PVector waveForceXPeriodSymetric(PVector p, int w, float periods, float strength) {
        float scale = periods/w;
        return new PVector( strength * sin(scale * p.x), 0 );
    }
    PVector waveForceYPeriodSymetric(PVector p, int h, float periods, float strength) {
        float scale = periods/h;
        return new PVector( 0, strength * sin(scale * p.y) );
    }
    PVector waveForcePeriodSymetric(PVector p, int w, int h, float periods, float strength) {
        float scaleX = periods/w;
        float scaleY = periods/h;
        return new PVector( strength * sin(scaleX * p.x), strength * cos(scaleY * p.y) );
    }
    PVector waveForcePeriodAsymetric(PVector p, float w, float h, float periodX, float periodY, float strength) {
        float scaleX = periodX/w;
        float scaleY = periodY/h;
        return new PVector( strength * sin(scaleX * p.x), strength * cos(scaleY * p.y) );
    }


    /* --------- Negative Forces --------- */

    // approximetly  calculates  the drag force
    PVector getDragForce(PVector velocity, PVector force) {
        /*
         float density = 1.2  // for Air https://en.wikipedia.org/wiki/Density
         float crossSection = 0.064 // asumming particles have mass of 1kg = 1 liter -> radius of sphere ca. 6.4 cm -> pi*r^2
         float dragCoefficient = 1.17 // https://en.wikipedia.org/wiki/Drag_coefficient
         float dragConstant = 0.5 * density * crossSection * dragCoefficient = 0.03744
         */
        float forceDrag = pow(velocity.mag(), 2) *  0.03744;
        PVector drag = force.copy(); // vecB = vecA -> vecB  points to A and changes to A get coppied into B. USE .copy()!!!
        drag.normalize();
        drag.mult(-forceDrag);
        return drag;
    }
    PVector getDragForce(AbstractParticle  particle) {
        float forceDrag = pow(particle.getVelocity().mag(), 2) *  0.03744;
        PVector drag = particle.getForce().copy(); // vecB = vecA -> vecB  points to A and changes to A get coppied into B. USE .copy()!!!
        drag.normalize();
        drag.mult(-forceDrag);
        return drag;
    }
    PVector getDragForce(AbstractParticle  particle, float dragConstant) {
        float forceDrag = pow(particle.getVelocity().mag(), 2) * dragConstant;
        PVector drag = particle.getForce().copy(); // vecB = vecA -> vecB  points to A and changes to A get coppied into B. USE .copy()!!!
        drag.normalize();
        drag.mult(-forceDrag);
        return drag;
    }

    // Kinetic Friction is a static value that must be overcome for forces to be applied
    // if force is overcome the static value is subtracted from originl force
    // mu = friction coefficient
    PVector getKineticFriction(float mu, float mass, PVector force) {
        float fKinetic  =  mu * mass * 9.81;
        float forceMagnitude = force.mag();
        forceMagnitude= forceMagnitude > fKinetic ? forceMagnitude - fKinetic : 0;
        PVector kinetic = force.copy();
        kinetic.normalize();
        kinetic.mult(forceMagnitude);
        return kinetic;
    }


    PVector limitForce(PVector a, float limit) {
        PVector newForce = a.copy();
        if (newForce.mag() > limit) {
            newForce.normalize().mult(limit - a.mag());
        }
        return newForce;
    }

    PVector limitVector(PVector vec, float limit) {
        PVector newVec = vec.copy();
        if (newVec.mag() > limit) {
            newVec.normalize().mult(limit);
        }
        return newVec;
    }
}
