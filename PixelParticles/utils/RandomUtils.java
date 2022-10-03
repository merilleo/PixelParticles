package PixelParticles.utils;

public class RandomUtils {
    public static float random(int max)   { return (float) (Math.random() * max); }
    public static float random(float max) { return (float) (Math.random() * max); }

    public static float random(float min, float max) { return (float) ((Math.random() * (max - min)) + min); }

    public static float random(int min, int max) {
        return (float) ((Math.random() * (max - min)) + min);
    }

}
