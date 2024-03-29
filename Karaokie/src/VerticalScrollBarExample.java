import javax.swing.*;
import java.awt.*;

public class VerticalScrollBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JPanel with Vertical Scrollbar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a JPanel with a larger preferred size than the JFrame
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(280, 400)); // Adjusted preferred size to show vertical scrollbar

        // Add some components to the panel
        for (int i = 0; i < 20; i++) { // Reduced number of components for demonstration
            panel.add(new JLabel("Label " + i));
        }

        // Create a JScrollPane and add the JPanel to it
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Set to NEVER

        // Add the JScrollPane to the JFrame
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}