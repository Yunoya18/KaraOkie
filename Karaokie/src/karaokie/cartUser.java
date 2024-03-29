/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author Tiraqmisu
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class cartUser extends JPanel implements ActionListener{
    private RoundedPanel out, in;
    private JPanel top, bot, order, blank, blank2;
    private JLabel id, room, lis, epr, etot, total;
    private JTextField count;
    private JButton co;
    private JScrollPane sc;
    private Box mid;
    public cartUser(){
        setBackground(Color.decode("#535870"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 27, 27));
        
//      outside box
        out = new RoundedPanel(20, 20, 1000, 600, Color.decode("#282B3A"));
        
//      inside box
        in = new RoundedPanel(20, 20, 950, 510, Color.decode("#A6ADCE"));
        
//      button
        co = new JButton("Confirm Order");
        
//      top panel
        top = new JPanel();
        top.setPreferredSize(new Dimension(930, 30));
        top.setBackground(Color.decode("#A6ADCE"));
        
        JPanel topgrid = new JPanel(new GridLayout(1, 2));
        topgrid.setPreferredSize(new Dimension(920, 40));
        topgrid.setBackground(Color.decode("#A6ADCE"));
        
        id = new JLabel("Order ID : ");
        id.setForeground(Color.decode("#282B3A"));
        id.setBackground(Color.decode("#A6ADCE"));
        
        JPanel pid = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pid.setBackground(Color.decode("#A6ADCE"));
        JPanel proom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        proom.setBackground(Color.decode("#A6ADCE"));
        
        room = new JLabel("Room : ");
        room.setForeground(Color.decode("#282B3A"));
        room.setBackground(Color.decode("#A6ADCE"));
        
        pid.add(id);
        proom.add(room);
        
        topgrid.add(pid);
        topgrid.add(proom);
        top.add(topgrid);
        
//      mid panel
        mid = Box.createVerticalBox();
        mid.setBackground(Color.decode("#A6ADCE"));
        
        sc = new JScrollPane(mid);
        sc.setPreferredSize(new Dimension(930, 370));
        sc.setBorder(BorderFactory.createLineBorder(Color.decode("#A6ADCE")));
        sc.setBackground(Color.decode("#A6ADCE"));
        sc.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#282B3A")));
        
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        this.addOrder();
        
//      bottom panel
        bot = new JPanel();
        bot.setPreferredSize(new Dimension(930, 50));
        bot.setBackground(Color.decode("#A6ADCE"));
        bot.setLayout(new FlowLayout(FlowLayout.RIGHT));
        total = new JLabel("Total : ");
        bot.add(total);
        
        in.add(top);
        in.add(sc);
        in.add(bot);
        out.add(in);
        out.add(co);
        add(out);
        
        co.addActionListener(this);
    }
//    String order, String price, String piece, String total
    public void addOrder(){
        JButton del = new JButton();
        ImageIcon i = new ImageIcon("D:\\work\\OOP\\Project\\KaraOkie\\src\\Icon\\minus.png");
        Image im = i.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(im);
        del.setIcon(icon);
        del.setBorderPainted(false);
        del.setFocusPainted(false);
        del.setBackground(Color.decode("#A6ADCE"));
        
        lis = new JLabel("you you you");
        lis.setForeground(Color.decode("#282B3A"));
        lis.setBackground(Color.decode("#A6ADCE"));
        
        blank = new JPanel();
        blank.setPreferredSize(new Dimension(570, 5));
        blank.setBackground(Color.decode("#A6ADCE"));
        
        epr = new JLabel("Price x ");
        epr.setForeground(Color.decode("#282B3A"));
        epr.setBackground(Color.decode("#A6ADCE"));
        
//      number of order that can edit
        count = new JTextField();
        count.setPreferredSize(new Dimension(30, 20));
        count.setForeground(Color.decode("#282B3A"));
        count.setBackground(Color.decode("#CFD7FA"));
        count.setBorder(BorderFactory.createLineBorder(Color.decode("#A6ADCE")));
        
        blank2 = new JPanel();
        blank2.setPreferredSize(new Dimension(40, 5));
        blank2.setBackground(Color.decode("#A6ADCE"));
        
        etot = new JLabel(" THB");
        etot.setForeground(Color.decode("#282B3A"));
        etot.setBackground(Color.decode("#A6ADCE"));
        
        order = new JPanel(new FlowLayout(FlowLayout.LEFT));
        order.setBackground(Color.decode("#A6ADCE"));
        order.add(del);
        order.add(lis);
        order.add(blank);
        order.add(epr);
        order.add(count);
        order.add(blank2);
        order.add(etot);
        
        mid.add(order);
        
        JButton g[] = new JButton[]{del, co};
        for(JButton button : g){
            button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {                        
                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));                       
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));                        
                }
            });
        }
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Are you sure that you want remove?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                    Container parent = del.getParent();
                    if (parent instanceof JPanel) {
                        JPanel orderPanel = (JPanel) parent;
                        mid.remove(orderPanel);
                        mid.revalidate();
                        mid.repaint();
                    }
                    mid.getParent().setBackground(Color.decode("#A6ADCE"));
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(co)){
            
        }
    }
    
    public static void main(String[] args) {
        new mainUser();
    }
}
