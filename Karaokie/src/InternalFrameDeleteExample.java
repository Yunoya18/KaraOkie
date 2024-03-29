import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternalFrameDeleteExample {
    private static int internalFrameCount = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Internal Frame Delete Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.add(desktopPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Internal Frame");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createInternalFrame(desktopPane);
            }
        });

        JButton deleteButton = new JButton("Delete Internal Frame");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JInternalFrame[] frames = desktopPane.getAllFrames();
                if (frames.length > 0) {
                    JInternalFrame frameToRemove = frames[frames.length - 1];
                    desktopPane.remove(frameToRemove);
                    desktopPane.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "No internal frames to delete.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void createInternalFrame(JDesktopPane desktopPane) {
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame " + (++internalFrameCount), true, true, true, true);
        internalFrame.setSize(200, 150);
        internalFrame.setLocation(internalFrameCount * 20, internalFrameCount * 20);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
    }
}
