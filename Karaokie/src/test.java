import javax.swing.*;
import java.awt.*;


public class test {
    private JFrame frame;
    private JPanel panel;
    public test(){
        frame = new JFrame();
        panel = new JPanel(new GridLayout(1, 2));
        
        panel.add(new JLabel("Room 1"));
        panel.add(new JLabel("available"));
        
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new test();
    }
}
