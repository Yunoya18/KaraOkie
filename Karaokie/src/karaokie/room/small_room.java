/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie.room;

import java.awt.*;
import javax.swing.*;


public class small_room extends room{
    private JPanel panel = new JPanel();
    
    public small_room(int roomNumber){
        super(roomNumber, "Small", 200, false); 
        
//        panel.add(new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 62.png")));
        panel.setPreferredSize(new Dimension(70, 50));
        
        panel.setBackground(Color.decode("#535870"));
        add(panel);
        pack();
        //setSize(500, 500);
        setVisible(true);
    
    }
    
}
