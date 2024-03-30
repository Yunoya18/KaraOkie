import javax.swing.*;
import java.awt.event.*;

public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

        JComboBox comboBox = new JComboBox();
        

        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) comboBox.getSelectedItem();
                    System.out.println("Selected item: " + selectedItem);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(comboBox);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
        comboBox.addItem("w1");
        comboBox.addItem("w2");
        comboBox.addItem("w3");
    }
}
