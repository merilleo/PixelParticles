package PixelParticles.utils;

import PixelParticles.Settings;

public class SketchDebugUtils {
    public static void showFramerate() {
        Settings.sketch.noStroke();
        Settings.sketch.fill(0,0,0);
        Settings.sketch.rect(0,0, 100, 50);
        Settings.sketch.fill(255,0,0);
        Settings.sketch.textSize(28);
        Settings.sketch.text(Settings.sketch.frameRate, 8, 32);
    }
}
