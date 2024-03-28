import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternalFrameExample {
    private static Point lastPosition;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Internal Frame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        // Create and add internal frame
        JInternalFrame internalFrame = new JInternalFrame("Title", true, true, true, true);
        internalFrame.setSize(200, 200);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);

        // Add component listener to track position changes
        internalFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                lastPosition = internalFrame.getLocation();
                System.out.println("Last position: " + lastPosition);
            }
        });

        frame.setVisible(true);
    }
}