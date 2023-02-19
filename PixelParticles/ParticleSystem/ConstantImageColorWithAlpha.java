package PixelParticles.ParticleSystem;

import PixelParticles.Image.Image;

import java.awt.*;

import static PixelParticles.utils.ColorUtils.convertToTransparentColor;
import static PixelParticles.utils.Positions.getNearestIndexFromVector;

public class ConstantImageColorWithAlpha implements ColorRecalculatorInterface {
    private Image image;
    private int alpha;

    public ConstantImageColorWithAlpha(Image image, int alpha) {
        this.image = image;
        this.alpha = alpha;
    }
    public Color getParticleColorFromImage(ParticleInterface particle) {
        int index = getNearestIndexFromVector( particle.getStartPosition(), this.image.getWidth() );
        return convertToTransparentColor(this.image.getPixel(index).getColor(), this.alpha);
    }
}
