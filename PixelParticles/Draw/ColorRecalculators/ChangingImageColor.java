package PixelParticles.Draw.ColorRecalculators;

import PixelParticles.utils.Image.Image;
import PixelParticles.ParticleSystem.ParticleInterface;

import java.awt.*;

import static PixelParticles.utils.ColorUtils.convertToTransparentColor;
import static PixelParticles.utils.Positions.getNearestIndexFromVector;

public class ChangingImageColor implements ColorRecalculatorInterface {
    private Image image;
    private int alpha;

    public ChangingImageColor(Image image, int alpha) {
        this.image = image;
        this.alpha = alpha;
    }
    public Color getParticleColorFromImage(ParticleInterface particle) {
        int index = getNearestIndexFromVector( particle.getPosition(), this.image.getWidth() );
        return convertToTransparentColor(this.image.getPixel(index).getColor(), this.alpha);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
