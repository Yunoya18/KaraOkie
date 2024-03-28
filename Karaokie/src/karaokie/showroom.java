
package karaokie;

import java.awt.*;
import javax.swing.*;


public class showroom extends JPanel{
    private JLabel t1,  t2;
    public showroom(String room, boolean use){
        setLayout(new GridLayout(1, 2));
        t1 = new JLabel("    "+ room);
        t2 = new JLabel("    "+use);
        
        t1.setForeground(Color.WHITE);
        if (use){
            t2.setForeground(Color.GREEN);
        }else{
            t2.setForeground(Color.RED);
        }
        
        t1.setFont(new Font("Arial", Font.PLAIN, 30));
        t2.setFont(new Font("Arial", Font.PLAIN, 30));
        
        add(t1);
        add(t2);
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(350, 100));
        setVisible(true);
    }
    

}
