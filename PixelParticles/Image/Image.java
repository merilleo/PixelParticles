package PixelParticles.Image;

import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;

import static PixelParticles.utils.Positions.getXFromIndex;
import static PixelParticles.utils.Positions.getYFromIndex;

public class Image implements ImageInterface {
    ArrayList<PixelInterface> pixels;
    int w;
    int h;

    public Image(int w, int h) {
        this.pixels = new ArrayList<PixelInterface>();
        this.w = w;
        this.h = h;
    }
    Image(ImageInterface img) {
        this.pixels = img.getPixelList();
        this.w = img.getWidth();
        this.h = img.getHeight();
    }

    public void setWidth(int w)  { this.w = w; }
    public void setHeight(int h) { this.h = h; }
    public int getWidth()  {return this.w; }
    public int getHeight() {return this.h; }

    public void addPixel(PixelInterface obj) { this.pixels.add(obj); }

    public PixelInterface getPixel(int index) {
        PixelInterface pixel = this.pixels.get(index);
        return  pixel.getClone(this.getWidth());
    }

    public ArrayList<PixelInterface> getPixelList() { return this.pixels; }

    public ImageInterface getClone() { return new Image(this); }

    public void importPImage(PImage img, PixelInterface pixelObject) {
        img.loadPixels();
        for (int i = 0; i < img.pixels.length; i++) {
            PixelInterface newPixel = pixelObject.getClone(this.w);
            newPixel.setIndex( i );
            newPixel.setX( getXFromIndex(i, this.w) );
            newPixel.setY( getYFromIndex(i, this.w) );
            newPixel.setColor( new Color(img.pixels[i]) );
            newPixel.setRGBA( new Color(img.pixels[i]) );
            this.addPixel( newPixel );
        }
    }
}
