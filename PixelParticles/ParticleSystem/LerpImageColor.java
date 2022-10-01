package PixelParticles.ParticleSystem;

import PixelParticles.Image.Image;

import java.awt.*;

import static PixelParticles.utils.ColorUtils.convertToTransparentColor;
import static PixelParticles.utils.ColorUtils.getLerpedColor;
import static PixelParticles.utils.Positions.getNearestIndexFromVector;

public class LerpImageColor implements ColorRecalculatorInterface {
    private Image image;
    private float smoothing;

    public LerpImageColor(Image image, float smoothing) {
        this.image = image;
        this.smoothing = smoothing;
    }

    public Color getParticleColorFromImage(ParticleInterface particle) {
        int index = getNearestIndexFromVector( particle.getPosition(), this.image.getWidth() );
        Color col = this.image.getPixel(index).getColor();
        return getLerpedColor(particle.getColor(), col, this.smoothing);
    }
}
