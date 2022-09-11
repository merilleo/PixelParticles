class ScreenWrapper {
    int w;
    int h;
    int buffer;

    ScreenWrapper(int w, int h) {
        this.w = w;
        this.h = h;
        this.buffer = 1;
    }
    
    private PVector getWrappedPosition(PVector p) {
      if (p.x < 0) {
            p.x = this.w - this.buffer;
        }
        if (p.x >= this.w) {
            p.x = 0 + this.buffer;
        }
        if (p.y < 0) {
            p.y = this.w - this.buffer;
        }
        if (p.y >= this.w) {
            p.y = 0 + this.buffer;
        }
        return p;
    }

    public PVector applyWrapping(PVector pos) {
        PVector  p = pos.copy();
        p = this.getWrappedPosition(p);
        return p;
    }

    public PVector applyWrapping(AbstractParticle  particle) {
        PVector  p = particle.getPosition().copy();
        p = this.getWrappedPosition(p);
        return p;
    }
}


class UtilityFunctions {
    public int getIndexFromXY(int x, int y, int width) {
        return ( x + y*width );
    }
    public int getXFromIndex(int index, int width) {
        return ( index % width );
    }
    public int getYFromIndex(int index, int width) {
        return ( floor(index / width) );
    }
    public int getNearestX(float x) {
        return (int) floor(x);
    }
    public int getNearestY(float y) {
        return (int) floor(y);
    }
    public int getNearestIndex(float x, float y, int width) {
        return this.getIndexFromXY((int) floor(x), (int) floor(y), width);
    }

    public void showFramerate() {
        noStroke();
        fill(0,0,0);
        rect(0,0, 100, 50);
        fill(255,0,0);
        textSize(28);
        text(frameRate, 8, 32); 
    }
}
