package PixelParticles.utils;

import PixelParticles.Forces.fields.FieldInterface;
import PixelParticles.Forces.fields.fieldObjects.ForceFieldObjectInterface;
import PixelParticles.ParticleSystem.ParticleInterface;
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

    public static void showFieldValues(FieldInterface field, ParticleInterface particle) {
        for (ForceFieldObjectInterface fieldObject : field.getCells()) {
            Settings.sketch.noStroke();
            Settings.sketch.fill(fieldObject.getForceVector(particle).x);
            float x = fieldObject.getColumn() * field.getCellWidth();
            float y = fieldObject.getRow() * field.getCellHeight();
            Settings.sketch.rect(x, y, field.getCellWidth(), field.getCellHeight());
        }
    }

    public static void drawScreenRect(int gray, float alpha) {
        Settings.sketch.noStroke();
        Settings.sketch.fill(gray, alpha);
        Settings.sketch.rect(0,0,Settings.sketch.width, Settings.sketch.height);
    }
}
