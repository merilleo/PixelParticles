import java.util.ArrayList;

interface AbstractImage {
    public void setWidth(int w);
    public void setHeight(int h);
    public int getWidth();
    public int getHeight();
    public void addPixel(AbstractPixel obj);
    public AbstractPixel getPixel(int index);
    public ArrayList<AbstractPixel> getPixelList();
    public AbstractImage getClone();
}

class Image implements AbstractImage {
    ArrayList<AbstractPixel> pixels;
    int w;
    int h;    

    Image(int w, int h) {
        this.pixels = new ArrayList<AbstractPixel>();
        this.w = w;
        this.h = h;
    }
    Image(AbstractImage img) {
        this.pixels = img.getPixelList();
        this.w = img.getWidth();
        this.h = img.getHeight();
    }

    public void setWidth(int w)  { this.w = w; }
    public void setHeight(int h) { this.h = h; }
    public int getWidth()  {return this.w; }
    public int getHeight() {return this.h; }

    public void addPixel(AbstractPixel obj) { this.pixels.add(obj); }

    public AbstractPixel getPixel(int index) { 
        AbstractPixel pixel = this.pixels.get(index);
        return  pixel.getClone(this.getWidth());
    }

    public ArrayList<AbstractPixel> getPixelList() { return this.pixels; }

    public AbstractImage getClone() { return new Image(this); }

    public void importPImage(PImage img, AbstractPixel pixelObject) {
        img.loadPixels();
        for (int i = 0; i < img.pixels.length; i++) {
            AbstractPixel newPixel = pixelObject.getClone(this.w);
            UtilityFunctions utils = new UtilityFunctions();
            newPixel.setIndex( i );
            newPixel.setX( utils.getXFromIndex(i, this.w) );
            newPixel.setY( utils.getYFromIndex(i, this.w) );
            newPixel.setColor( img.pixels[i] );
            newPixel.setRGBA( img.pixels[i] );
            this.addPixel( newPixel ); 
        }
    }
}