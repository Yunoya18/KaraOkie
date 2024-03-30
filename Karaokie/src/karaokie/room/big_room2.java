
package karaokie.room;

import java.awt.*;
import javax.swing.*;

public class big_room2 extends room{
    private JPanel panel = new JPanel();
    
    public big_room2(int roomNumber){
        super(roomNumber, "Big", 300, false); 
        
//        panel.add(new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 63.png")));
        panel.setPreferredSize(new Dimension(140, 50));
        
        panel.setBackground(Color.decode("#535870"));
        add(panel);
        pack();
        //setSize(500, 500);
        setVisible(true);
    }
    
}
