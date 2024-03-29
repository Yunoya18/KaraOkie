/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

import javax.swing.*;
import java.awt.*;


public class showorder extends JPanel{
    private JPanel panel2;
    private JLabel name;
    private JScrollPane sp;
    // String s, Map<Food>, <Integer> m, int row
    public showorder(String s, int row){
        name = new JLabel("Order : Room " + s);
        setLayout(new BorderLayout());
        
        panel2 = new JPanel(new GridLayout(row, 1));
        
        name.setFont(new Font("Arial", Font.PLAIN, 35));
        name.setForeground(Color.WHITE);
        
        // SET FOOD NAME
        for (int i=0;i<row;i++){
            JLabel tx1 = new JLabel("    teste");
            tx1.setFont(new Font("Arial", Font.PLAIN, 20));
            tx1.setForeground(Color.WHITE);
            panel2.add(tx1);
        }
        
        panel2.setBackground(Color.BLACK);
        panel2.setPreferredSize(new Dimension(350, 30 * row));
        
        sp = new JScrollPane(panel2);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(name, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(350, 400));        
    }

}
