import java.awt.image.BufferedImage;

public class OFImage extends BufferedImage {

    public OFImage(BufferedImage image) {
        super(image.getColorModel(),
              image.getRaster(),
              image.isAlphaPremultiplied(),
              null);
    }

    public void darker() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int rgb = getRGB(x, y);
                setRGB(x, y, adjustBrightness(rgb, 0.8));
            }
        }
    }

    public void lighter() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int rgb = getRGB(x, y);
                setRGB(x, y, adjustBrightness(rgb, 1.2));
            }
        }
    }

    public void threshold() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int rgb = getRGB(x, y);
                int gray = (int) ((0.3 * ((rgb >> 16) & 0xFF)) +
                                  (0.59 * ((rgb >> 8) & 0xFF)) +
                                  (0.11 * (rgb & 0xFF)));
                int thresholdValue = (gray > 128) ? 255 : 0;
                int newRgb = (thresholdValue << 16) | (thresholdValue << 8) | thresholdValue;
                setRGB(x, y, newRgb);
            }
        }
    }

    private int adjustBrightness(int rgb, double factor) {
        int r = Math.min(255, (int) (((rgb >> 16) & 0xFF) * factor));
        int g = Math.min(255, (int) (((rgb >> 8) & 0xFF) * factor));
        int b = Math.min(255, (int) ((rgb & 0xFF) * factor));
        return (r << 16) | (g << 8) | b;
    }
}
