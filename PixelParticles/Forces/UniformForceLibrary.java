package PixelParticles.Forces;

import PixelParticles.Forces.LinearForce;
import PixelParticles.Forces.RandomForce;
import processing.core.PVector;

public class UniformForceLibrary {
    public static LinearForce LINEAR = new LinearForce();
    public static RandomForce RANDOM = new RandomForce();
    public static DragForce DRAG = new DragForce();


    public static class LinearForceSettings {

        public static void direction(PVector direction) {
            LINEAR.setDirection(direction);
        }
        public static void direction(float x, float y) {
            LINEAR.setDirection(new PVector(x, y));
        }
        public static void strength(float strength) {
            LINEAR.setStrength(strength);
        }

    }
    public static class RandomForceSettings {
        public static void seed(int seed) {
            RANDOM.setSeed(seed);
        }
        public static void strength(float strength) {
            RANDOM.setStrength(strength);
        }
    }

    public static class DragForceSettings {
        public static void strength(float strength) {
            DRAG.setStrength(strength);
        }
    }

}
