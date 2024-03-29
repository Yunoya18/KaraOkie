import javax.swing.*;
import java.awt.*;

public class ShowOrder2 extends JPanel {
    private JPanel panel2;
    private JLabel name;
    private JScrollPane sp;

    public ShowOrder2(String s, int row) {
        name = new JLabel("Order : Room " + s);
        setLayout(new BorderLayout()); // Use BorderLayout for better layout management

        // Initialize panel2 with GridLayout
        panel2 = new JPanel(new GridLayout(row, 1));

        name.setFont(new Font("Arial", Font.PLAIN, 35));
        name.setForeground(Color.WHITE);

        // Set FOOD NAME
        JLabel tx1 = new JLabel("teste");
        tx1.setFont(new Font("Arial", Font.PLAIN, 20));
        tx1.setForeground(Color.WHITE);
        JLabel tx2 = new JLabel("t24te");
        tx2.setFont(new Font("Arial", Font.PLAIN, 20));
        tx2.setForeground(Color.WHITE);

        // Add labels to panel2
        panel2.add(tx1);
        panel2.add(tx2);

        // Set background color and preferred size for panel2
        panel2.setBackground(Color.BLACK);
        panel2.setPreferredSize(new Dimension(350, 30 * row));

        // Create JScrollPane with panel2
        sp = new JScrollPane(panel2);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add components to the showorder panel
        add(name, BorderLayout.NORTH); // Place name label at the top
        add(sp, BorderLayout.CENTER);  // Place JScrollPane at the center

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(350, 400));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Show Order Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500); // Set frame size

        ShowOrder2 showOrder = new ShowOrder2("1", 2); // Create ShowOrder instance
        frame.add(showOrder); // Add ShowOrder panel to the frame

        frame.setVisible(true); // Make the frame visible
    }
}