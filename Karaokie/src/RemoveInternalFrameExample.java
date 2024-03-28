import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveInternalFrameExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Remove Internal Frame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JDesktopPane desktopPane = new JDesktopPane();

        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setSize(200, 200);
        internalFrame.setVisible(true);

        JButton removeButton = new JButton("Remove Internal Frame");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the JDesktopPane and remove the internal frame
                desktopPane.remove(internalFrame);
                desktopPane.repaint(); // Repaint the desktop pane to reflect changes
            }
        });

        frame.add(desktopPane, BorderLayout.CENTER);
        frame.add(removeButton, BorderLayout.SOUTH);
        frame.setVisible(true);

        desktopPane.add(internalFrame);
    }
}
