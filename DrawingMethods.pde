interface AbstractDrawingMethode {
    public void drawParticle(AbstractParticle particle);
}

class DrawSquare implements AbstractDrawingMethode {
    float size;

    DrawSquare(float size) {
        this.size = size;
    }

    public void drawParticle(AbstractParticle p) {
        noStroke();
        fill( p.getColor() );
        rect( p.getX(), p.getY(), this.size, this.size );
    }
}

/*
class DrawingMethods {

    void rectangle(float x, float y, float size, color col) {
        noStroke();
        fill(col);
        rect(x, y, size, size);
    }
    void rectangle(PVector p, float size, color col) {
        noStroke();
        fill(col);
        rect(p.x, p.y, size, size);
    }
    void rectangle(AbstractParticle particle, float size) {
        noStroke();
        fill(particle.getColor());
        rect(particle.getPosition().x, particle.getPosition().y, size, size);
    }
}
*/
