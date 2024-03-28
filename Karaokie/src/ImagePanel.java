import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private String text;

    public ImagePanel(String imagePath, String text) {
        try {
            image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 35.png"));
            this.text = text;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            if (text != null) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(text);
                int x = (getWidth() - textWidth) / 2;
                int y = getHeight() / 2;
                g.drawString(text, x, y);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        String imagePath = "image.jpg"; // Path to your image file
        String text = "Hello World!";

        ImagePanel panel = new ImagePanel(imagePath, text);
        frame.add(panel);

        frame.setVisible(true);
    }
}