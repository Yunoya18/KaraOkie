
package karaokie;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class showalert extends JPanel{
    private JLabel t1;
    public showalert(String room){
        setLayout(new GridLayout(1, 2));
        
        t1 = new JLabel("    Room " + room + " Need Help");

        t1.setFont(new Font("Arial", Font.PLAIN, 30));
        t1.setForeground(Color.WHITE);
        
        add(t1);
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(350, 100));
        setVisible(true);
        
    }

}
