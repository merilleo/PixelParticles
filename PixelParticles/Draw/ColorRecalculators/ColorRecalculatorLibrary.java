package PixelParticles.Draw.ColorRecalculators;

import PixelParticles.Settings;
import PixelParticles.utils.Image.Image;

public class ColorRecalculatorLibrary {
    /* TODO create input settings for velocity */
    public static final VelocityColor VELOCITY = new VelocityColor();
    public static ChangingImageColor CHANGING_IMAGE = new ChangingImageColor(Settings.defaultImage, 255);
    public static ConstantImageColor CONSTANT_IMAGE = new ConstantImageColor(Settings.defaultImage, 255);

    public static class ChangingImageColorSettings {
        // TODO alpha deosn't work
        public static void alpha(int alpha) {
            CHANGING_IMAGE.setAlpha(alpha);
        }
        public static void image(Image image) {
            CHANGING_IMAGE.setImage(image);
        }

    }
    public static class ConstantImageColorSettings {
        // TODO alpha deosn't work
        public static void alpha(int alpha) {
            CONSTANT_IMAGE.setAlpha(alpha);
        }
        public static void image(Image image) {
            CONSTANT_IMAGE.setImage(image);
        }
    }

}
