
package karaokie;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Set;
import javax.swing.*;
import karaokie.room.Controller;


public class showroom extends JPanel implements MouseListener{
    private JLabel t1, t2;
    private RoundedPanel rp;
    private JPanel p;
    private final String room;
    public showroom(String room, boolean use){
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Regular.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        this.room = room;
        
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
                Controller.setavailable(this);
            } else {
                t2.setText("Available");
                t2.setForeground(Color.GREEN);
                Controller.setavailable(this);
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
        t2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        t2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    public String getRoom(){
        return room;
    }
}
