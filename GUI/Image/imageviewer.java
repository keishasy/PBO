import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer {
    private JFrame frame;
    private ImagePanel imagePanel;
    private ImageFileManager fileManager;

    public ImageViewer() {
        frame = new JFrame("ImageViewer V-1");
        imagePanel = new ImagePanel();
        fileManager = new ImageFileManager();

        setupMenu();
        frame.add(imagePanel, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem quitItem = new JMenuItem("Quit");

        openItem.addActionListener(e -> openImage());
        saveItem.addActionListener(e -> saveImage());
        closeItem.addActionListener(e -> imagePanel.clearImage());
        quitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        fileMenu.add(quitItem);

        JMenu filterMenu = new JMenu("Filter");
        JMenuItem darkerItem = new JMenuItem("Darker");
        JMenuItem lighterItem = new JMenuItem("Lighter");
        JMenuItem thresholdItem = new JMenuItem("Threshold");

        darkerItem.addActionListener(e -> imagePanel.applyFilter(OFImage::darker));
        lighterItem.addActionListener(e -> imagePanel.applyFilter(OFImage::lighter));
        thresholdItem.addActionListener(e -> imagePanel.applyFilter(OFImage::threshold));

        filterMenu.add(darkerItem);
        filterMenu.add(lighterItem);
        filterMenu.add(thresholdItem);

        menuBar.add(fileMenu);
        menuBar.add(filterMenu);

        frame.setJMenuBar(menuBar);
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            OFImage image = fileManager.loadImage(file);
            if (image != null) {
                imagePanel.setImage(image);
            }
        }
    }

    private void saveImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileManager.saveImage(imagePanel.getImage(), file);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageViewer::new);
    }
}
