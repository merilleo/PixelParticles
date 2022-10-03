package PixelParticles.utils;

import processing.core.PVector;

public class MathUtils {
    public static float minMaxValue(float val, float min, float max) {
        val = Math.max(val, min);
        val = Math.min(val, max);
        return val;
    }

    public static float getSmoothedValue(float value, float newValue, float smoothingFactor) {
        return value + ((newValue - value) * smoothingFactor);
    }

    public static PVector multiplyTwoVectors(PVector v1, PVector v2) {
        float x = v1.x * v2.x;
        float y = v1.y * v2.y;
        return new PVector(x, y);
    }
}
