/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

import javax.swing.*;
import java.awt.*;


public class showorder extends JPanel{
    private JPanel panel2, p;
    private JLabel name;
    private JScrollPane sp;
    private RoundedPanel rp;
    // String s, Map<Food>, <Integer> m, int row
    public showorder(String s, int row){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        name = new JLabel("Order : Room " + s);
        p = new JPanel(new BorderLayout());
        
        panel2 = new JPanel(new GridLayout(row, 1));
        
        name.setFont(new Font("Montserrat", Font.BOLD, 33));
        name.setForeground(Color.decode("#A6ADCE"));
        
        // SET FOOD NAME
        for (int i=0;i<row;i++){
            JLabel tx1 = new JLabel("    teste");
            tx1.setFont(new Font("Montserrat", Font.BOLD, 18));
            tx1.setForeground(Color.decode("#A6ADCE"));
            panel2.add(tx1);
        }
        
        panel2.setBackground(Color.decode("#282B3A"));
        panel2.setPreferredSize(new Dimension(270, 40 * row));
        
        sp = new JScrollPane(panel2);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(BorderFactory.createEmptyBorder());
        
        p.add(name, BorderLayout.NORTH);
        p.add(sp, BorderLayout.CENTER);
        
        p.setBackground(Color.decode("#282B3A"));
        p.setPreferredSize(new Dimension(280, 390));
        rp = new RoundedPanel(20, 20, 310, 410, Color.decode("#282B3A"), 1.0f, 10);
        rp.add(p);
        
        add(rp);
        setPreferredSize(new Dimension(320, 420));
        setBackground(Color.decode("#1C1E27"));
        setVisible(true);
    }

}
