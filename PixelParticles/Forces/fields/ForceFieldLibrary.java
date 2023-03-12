package PixelParticles.Forces.fields;

import PixelParticles.Forces.fields.fieldObjects.ForceFieldObjectInterface;
import PixelParticles.Forces.fields.fieldObjects.PerlinForceFieldObject;
import PixelParticles.Forces.fields.fieldObjects.RandomForceFieldObject;
import PixelParticles.Settings;
import PixelParticles.utils.Image.Image;

public class ForceFieldLibrary {
    public static RandomForceFieldObject RANDOM_OBJECT = new RandomForceFieldObject();
    public static ForceField RANDOM_FIELD = new ForceField(10, 10, Settings.width, Settings.height, 1.0F, RANDOM_OBJECT);
    public static PerlinForceFieldObject PERLIN_OBJECT = new PerlinForceFieldObject(0.5F);
    public static ForceField PERLIN_FIELD = new ForceField(10, 10, Settings.width, Settings.height, 1.0F, PERLIN_OBJECT);

    public static class RandomFieldSettings {
        public static void columns(int columns) {
            RANDOM_FIELD.setColumns(columns);
        }
        public static void rows(int rows) {
            RANDOM_FIELD.setRows(rows);
        }
        public static void width(int width) {
            RANDOM_FIELD.setWidth(width);
        }
        public static void height(int height) {
            RANDOM_FIELD.setHeight(height);
        }
        public static void strength(float strength) {
            RANDOM_FIELD.setStrength(strength);
        }
    }

    public static class PerlinFieldSettings {
        public static void columns(int columns) {
            PERLIN_FIELD.setColumns(columns);
        }
        public static void rows(int rows) {
            PERLIN_FIELD.setRows(rows);
        }
        public static void width(int width) {
            PERLIN_FIELD.setWidth(width);
        }
        public static void height(int height) {
            PERLIN_FIELD.setHeight(height);
        }
        public static void strength(float strength) {
            PERLIN_FIELD.setStrength(strength);
        }
    }
}
