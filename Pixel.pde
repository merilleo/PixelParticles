interface AbstractPixel {
    public void setIndex(int index);
    public void setX(int x);
    public void setY(int y);
    public void setColor(color col);
    public void setRGBA(color col);
    public void setRed(float r);
    public void setGreen(float g);
    public void setBlue(float b);
    public void setAlpha(float  a);

    public int getIndex();
    public int getX();
    public int getY();
    public color getColor();
    public float getRed();
    public float getGreen();
    public float getBlue();
    public float getAlpha();
    public AbstractPixel getClone(int width);
}

class Pixel implements AbstractPixel{
    int index;
    int x;
    int y;
    color col;
    float r;
    float g;
    float b;
    float a;

    public Pixel(int index, int width, color col) {
        UtilityFunctions utils = new UtilityFunctions();
        this.index = index;
        this.x = utils.getXFromIndex(index, width);
        this.y = utils.getYFromIndex(index, width);
        this.col = col;
        this.r = red(col);
        this.g = green(col);
        this.b = blue(col);
        this.a  = alpha(col);
    }
    
    public Pixel(AbstractPixel pix, int width) {
        UtilityFunctions utils = new UtilityFunctions();
        this.index = pix.getIndex();
        this.x = utils.getXFromIndex(pix.getIndex(), width);
        this.y = utils.getYFromIndex(pix.getIndex(), width);
        this.col = pix.getColor();
        this.r = pix.getRed();
        this.g = pix.getGreen();
        this.b = pix.getBlue();
        this.a  = pix.getAlpha();
    }

    public void setIndex(int index) { this.index = index; }
    public void setX(int x)         { this.x = x; }
    public void setY(int y)         { this.y = y; }
    public void setColor(color col) { this.col = col; }
    public void setRed(float r)     { this.r = r; }
    public void setGreen(float g)   { this.g = g; }
    public void setBlue(float b)    { this.b = b; }
    public void setAlpha(float a)   { this.a = a; }
    public void setRGBA(color col) {
        this.r = red(col);
        this.g = green(col);
        this.b = blue(col);
        this.a = alpha(col);
    }

    public int   getIndex() { return this.index ;}
    public int   getX()     { return this.x ;}
    public int   getY()     { return this.y ;}
    public color getColor() { return this.col ;}
    public float getRed()   { return this.r ;}
    public float getGreen() { return this.g ;}
    public float getBlue()  { return this.b ;}
    public float getAlpha() { return this.a ;}
    public AbstractPixel getClone(int width) { return new Pixel(this, width); }
}
