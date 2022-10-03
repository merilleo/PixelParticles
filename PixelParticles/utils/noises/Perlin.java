package PixelParticles.utils.noises;

import PixelParticles.Settings;
import processing.core.PVector;


import static processing.core.PApplet.floor;
/*
* Reference: https://de.wikipedia.org/wiki/Perlin-Noise#:~:text=Perlin%20Noise%20ist%20eine%20Rauschfunktion,er%201997%20einen%20Oscar%20erhielt.
* */
public class Perlin {

    private static float randomGenerator() {
        return Settings.rngGenerator.nextFloat()*0.5F;
    }

    private static float interpolate(float a0, float a1, float x) {
        if (x < 0.0) return a0;
        if (x > 1.0) return a1;
        return (a1 - a0) * x + a0;
        //return (a1 - a0) * (3.0 - x * 2.0) * x * x + a0; // Alternative: Kubische Interpolation mit dem Polynom 3 * x^2 - 2 * x^3
        //return (a1 - a0) * ((x * (x * 6.0 - 15.0) + 10.0) * x * x * x) + a0; // Alternative:  Interpolation mit dem Polynom 6 * x^5 - 15 * x^4 + 10 * x^3
    }

    private static float dotGridGradient (int ix, int iy, PVector vec) {
        PVector rngVec = new PVector(randomGenerator(), randomGenerator());
        float dx = vec.x - (float) ix;
        float dy = vec.y - (float) iy;
        return dx * rngVec.x + dy * rngVec.y;
    }


    public static float perlin(PVector pos) {
        int x0 = floor(pos.x);
        int x1 = x0 + 1;
        int y0 = floor(pos.y);
        int y1 = y0 + 1;

        float sx = pos.x - (float) x0;
        float sy = pos.y - (float) y0;


        float n0, n1, ix0, ix1;

        n0  = dotGridGradient(x0, y0, pos);
        n1  = dotGridGradient(x1, y0, pos);
        ix0 = interpolate(n0, n1, sx);
        n0  = dotGridGradient(x0, y1, pos);
        n1  = dotGridGradient(x1, y1, pos);
        ix1 = interpolate(n0, n1, sx);
        return interpolate(ix0, ix1, sy);
    }
}
