import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageFileManager {
    public OFImage loadImage(File file) {
        try {
            return new OFImage(ImageIO.read(file));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveImage(OFImage image, File file) {
        try {
            ImageIO.write(image, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
