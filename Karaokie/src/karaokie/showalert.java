
package karaokie;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class showalert extends JPanel{
    private JLabel t1;
    private RoundedPanel rp;
    private JPanel p;
    public showalert(String room){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        t1 = new JLabel("Room " + room + " Need Help");

        t1.setFont(new Font("Montserrat", Font.BOLD, 25));
        t1.setForeground(Color.decode("#A6ADCE"));
        
        p.add(t1);
        
        p.setBackground(Color.decode("#282B3A"));
        p.setPreferredSize(new Dimension(300, 50));
        
        rp = new RoundedPanel(20, 20, 310, 100, Color.decode("#282B3A"), 1.0f, 30);
        rp.add(p);
        
        add(rp);
        setPreferredSize(new Dimension(320, 110));
        setBackground(Color.decode("#1C1E27"));
        
        setVisible(true);
        
    }

}