/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author mansu
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class roompage extends JPanel{
    public roompage(){
        JTextField srch = new JTextField();
        setLayout(new BorderLayout(0,0));
        setBackground(Color.decode("#535870"));
        JPanel func = new JPanel();
        JPanel up = new JPanel();
        JButton room = new JButton();
        JButton order = new JButton();
        JButton report = new JButton();
        JPanel cen = new JPanel();
        String[] roomcat = {"Big", "Small"};
        JComboBox type = new JComboBox(roomcat);
        
        up.setLayout(new BorderLayout(0,0));
        add(func, BorderLayout.WEST);
        func.setPreferredSize(new Dimension(200, 720));
        func.setBackground(Color.decode("#282B3A"));
        func.setLayout(new BorderLayout(0,0));
        func.add(up, BorderLayout.NORTH);
        up.add(srch, BorderLayout.NORTH);
        up.add(cen, BorderLayout.CENTER);
        cen.add(room, BorderLayout.WEST);
        cen.add(order, BorderLayout.CENTER);
        cen.add(report, BorderLayout.EAST);
        up.setBackground(Color.decode("#1C1E27"));
        cen.setBackground(Color.decode("#1C1E27"));
        up.setPreferredSize(new Dimension(200, 150));
        up.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        up.add(type, BorderLayout.SOUTH);
        cen.setLayout(new FlowLayout());
        
        
        room.setPreferredSize(new Dimension(55, 60));
        order.setPreferredSize(new Dimension(55, 60));
        report.setPreferredSize(new Dimension(55, 60));
        type.setPreferredSize(new Dimension(120, 60));
        
        
        srch.setPreferredSize(new Dimension(180, 30));
        setVisible(true);
//        pm.add(pg);
//        
//        pm.setVisible(true);
//        pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pm.pack();
//        pm.setSize(1280, 720);
    
}
}
