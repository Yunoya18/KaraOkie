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
public class main implements ActionListener{
    private JFrame ma;
    private JDesktopPane side;
    private JPanel menu, blank, p1, p2, p3, p4, p5, tab;
    private JMenu ic1, ic2, ic3, ic4, ic5;
    private JButton pg1, pg2, pg3, pg4, pg5;
    private CardLayout cardlayout;
    public main(){
        ma = new JFrame("karaOkie");
        menu = new JPanel();
        cardlayout = new CardLayout();
        tab = new JPanel(cardlayout);
        blank = new JPanel();
        pg2 = new JButton();
        pg3 = new JButton();
        pg4 = new JButton();
        pg5 = new JButton();
        pg1 = new JButton();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p1.setBackground(Color.decode("#535870"));
        p2.setBackground(Color.decode("#535870"));
        p3.setBackground(Color.decode("#535870"));
        p4.setBackground(Color.decode("#535870"));
        p5.setBackground(Color.decode("#535870"));
        //set Icon Image
        ImageIcon i1 = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\Icon\\room.png");
        Image img1 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon1 = new ImageIcon(img1);
        ImageIcon i2 = new ImageIcon("C:\\Users\\mansu\\Downloads\\create-order.png");
        Image img2 = i2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon2 = new ImageIcon(img2);
        ImageIcon i3 = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\Icon\\tips-2.png");
        Image img3 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon3 = new ImageIcon(img3);
        ImageIcon i4 = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\Icon\\membership-card.png");
        Image img4 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon4 = new ImageIcon(img4);
        ImageIcon i5 = new ImageIcon("C:\\Users\\mansu\\OneDrive - KMITL\\Desktop\\Icon\\bar-chart.png");
        Image img5 = i5.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        Icon icon5 = new ImageIcon(img5);
        pg1.setIcon(icon1);
        pg2.setIcon(icon2);
        pg3.setIcon(icon3);
        pg4.setIcon(icon4);
        pg5.setIcon(icon5);
        ma.setLayout(new BorderLayout(0, 0));
        menu.setBackground(Color.decode("#282B3A"));
        blank.setBackground(Color.decode("#282B3A"));
        menu.setPreferredSize(new Dimension(50, 190));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        ma.add(menu, BorderLayout.WEST); 
        ma.add(tab, BorderLayout.CENTER);
        tab.setBackground(Color.decode("#535870"));
        tab.add(p1, "pg1");
        tab.add(p2, "pg2");
        tab.add(p3, "pg3");
        tab.add(p4, "pg4");
        tab.add(p5, "pg5");
        
        menu.add(blank);
        menu.add(pg1);
        menu.add(pg2);
        menu.add(pg3);
        menu.add(pg4);
        menu.add(pg5);
        blank.setPreferredSize(new Dimension(30, 30));
        pg1.setPreferredSize(new Dimension(50, 50));
        pg2.setPreferredSize(new Dimension(50, 50));
        pg3.setPreferredSize(new Dimension(30, 30));
        pg4.setPreferredSize(new Dimension(30, 30));
        pg5.setPreferredSize(new Dimension(30, 30));
        pg1.setBackground(Color.decode("#282B3A"));
        pg2.setBackground(Color.decode("#282B3A"));
        pg3.setBackground(Color.decode("#282B3A"));
        pg4.setBackground(Color.decode("#282B3A"));
        pg5.setBackground(Color.decode("#282B3A"));
        pg1.setBorderPainted(false);
        pg1.setFocusPainted(false);
        pg2.setBorderPainted(false);
        pg2.setFocusPainted(false);
        pg3.setBorderPainted(false);
        pg3.setFocusPainted(false);
        pg4.setBorderPainted(false);
        pg4.setFocusPainted(false);
        pg5.setBorderPainted(false);
        pg5.setFocusPainted(false);
        
        JButton[] group = new JButton[]{pg1, pg2, pg3, pg4, pg5};
        
        for(JButton button : group){
              button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // Change cursor to hand cursor when mouse enters button
                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        button
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        // Reset cursor when mouse exits button
                        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });
        }
        
        UIManager.getLookAndFeelDefaults().put("Button.select", new Color(0, 0, 0, 0));
        
        ma.setSize(1280, 720);
        ma.setVisible(true);
        ma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //button action
        pg1.addActionListener(this);
        pg2.addActionListener(this);
        pg3.addActionListener(this);
        pg4.addActionListener(this);
        pg5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(pg1)){
           cardlayout.show(tab, "pg1");
        }
        else if(ev.getSource().equals(pg2)){
           cardlayout.show(tab, "pg2");
        }
        else if(ev.getSource().equals(pg3)){
           cardlayout.show(tab, "pg3");
        }
        else if(ev.getSource().equals(pg4)){
           cardlayout.show(tab, "pg4");
        }
        else if(ev.getSource().equals(pg5)){
           cardlayout.show(tab, "pg5");
        }
    }
    public static void main(String[] args) {
        new main();
    }
    }
    
    }

