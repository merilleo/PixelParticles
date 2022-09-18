package PixelParticles.Image;

import java.util.ArrayList;

public interface ImageInterface {
     void setWidth(int w);
     void setHeight(int h);
     int getWidth();
     int getHeight();
     void addPixel(PixelInterface obj);
     PixelInterface getPixel(int index);
     ArrayList<PixelInterface> getPixelList();
     ImageInterface getClone();
}
