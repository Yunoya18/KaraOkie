
package karaokie;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class showroom extends JPanel implements MouseListener{
    private JLabel t1,  t2;
    public showroom(String room, boolean use){
        setLayout(new GridLayout(1, 2));
        
        t1 = new JLabel("    " + room);
        t2 = new JLabel("    ");
        t1.setForeground(Color.WHITE);
        if (use){
            t2.setForeground(Color.GREEN);
            t2.setText("Available");
        }else{
            t2.setForeground(Color.RED);
            t2.setText("Not-Available");
        }
        
        
        
        t1.setFont(new Font("Arial", Font.PLAIN, 30));
        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        
        add(t1);
        add(t2);
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(350, 100));
        setVisible(true);
        
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            System.out.println("Double");
            if (t2.getText().equals("Available")) {
                t2.setText("Not-Available");
                t2.setForeground(Color.RED);
            } else {
                t2.setText("Available");
                t2.setForeground(Color.GREEN);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    

}
