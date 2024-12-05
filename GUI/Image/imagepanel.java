import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private OFImage image;

    public void setImage(OFImage image) {
        this.image = image;
        repaint();
    }

    public OFImage getImage() {
        return image;
    }

    public void clearImage() {
        image = null;
        repaint();
    }

    public void applyFilter(Filter filter) {
        if (image != null) {
            filter.apply(image);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            // Calculate aspect ratios
            double imageAspect = (double) imageWidth / imageHeight;
            double panelAspect = (double) panelWidth / panelHeight;

            int drawWidth, drawHeight;

            // Determine the size of the image to maintain aspect ratio
            if (imageAspect > panelAspect) {
                drawWidth = panelWidth;
                drawHeight = (int) (panelWidth / imageAspect);
            } else {
                drawHeight = panelHeight;
                drawWidth = (int) (panelHeight * imageAspect);
            }

            // Center the image within the panel
            int x = (panelWidth - drawWidth) / 2;
            int y = (panelHeight - drawHeight) / 2;

            // Draw the image
            g.drawImage(image, x, y, drawWidth, drawHeight, null);
        }
    }

    public interface Filter {
        void apply(OFImage image);
    }
}
