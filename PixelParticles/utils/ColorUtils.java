package PixelParticles.utils;

import java.awt.*;

import static PixelParticles.utils.MathUtils.getSmoothedValue;
import static PixelParticles.utils.MathUtils.minMaxValue;

public class ColorUtils {
    public static Color convertToTransparentColor(Color col, int alpha) {
        return new Color(col.getRed(), col.getGreen(), col.getBlue(), alpha);
    }
    public static Color getLerpedColor(Color oldCol, Color newCol, float smoothing) {
        int r = (int) getSmoothedValue(oldCol.getRed(), newCol.getRed(), smoothing);
        int g = (int) getSmoothedValue(oldCol.getGreen(), newCol.getGreen(), smoothing);
        int b = (int) getSmoothedValue(oldCol.getBlue(), newCol.getBlue(), smoothing);
        int a = (int) getSmoothedValue(oldCol.getAlpha(), newCol.getBlue(), smoothing);

        r = (int) minMaxValue(r, 0, 255);
        g = (int) minMaxValue(g, 0, 255);
        b = (int) minMaxValue(b, 0, 255);
        a = (int) minMaxValue(a, 0, 255);

        return new Color(r, g, b, a);
    }
}
