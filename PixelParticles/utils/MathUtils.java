package PixelParticles.utils;

public class MathUtils {
    public static float minMaxValue(float val, float min, float max) {
        val = (val <= min) ? min : val;
        val = (val >= max) ? max : val;
        return val;
    }

    public static float getSmoothedValue(float value, float newValue, float smoothingFactor) {
        return value + ((newValue - value) * smoothingFactor);
    }
}
