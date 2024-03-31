
package karaokie;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class showroom extends JPanel implements MouseListener{
    private JLabel t1, t2;
    private RoundedPanel rp;
    private JPanel p;
    public showroom(String room, boolean use){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        p = new JPanel(new GridLayout(1, 2));
        
        t1 = new JLabel(room);
        t2 = new JLabel();
        t1.setForeground(Color.decode("#A6ADCE"));
        if (use){
            t2.setForeground(Color.GREEN);
            t2.setText("Available");
        }else{
            t2.setForeground(Color.RED);
            t2.setText("Not-Available");
        }
        
        t1.setFont(new Font("Montserrat", Font.BOLD, 25));
        t2.setFont(new Font("Montserrat", Font.BOLD, 18));
        
        p.add(t1);
        p.add(t2);
        
        p.setBackground(Color.decode("#282B3A"));
        p.setPreferredSize(new Dimension(270, 50));
        
        p.addMouseListener(this);
        
        rp = new RoundedPanel(20, 20, 310, 100, Color.decode("#282B3A"), 1.0f, 25);
        rp.add(p);
        
        add(rp);
        setPreferredSize(new Dimension(320, 110));
        setBackground(Color.decode("#1C1E27"));
        setVisible(true);
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
