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
    private JPanel menu, blank, p1, p2, p3, p4, p5;
    private JMenu ic1, ic2, ic3, ic4, ic5;
    private JButton pg1, pg2, pg3, pg4, pg5;
    private JTabbedPane tab;
    public main(){
        ma = new JFrame("karaOkie");
        menu = new JPanel();
        tab = new JTabbedPane();
        blank = new JPanel();
        pg2 = new JButton();
        pg3 = new JButton();
        pg4 = new JButton();
        pg5 = new JButton();
        pg1 = new JButton();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        // change bg color na
        p1.setBackground(Color.decode("#535870"));
        p2.setBackground(Color.decode("#535870"));
        p3.setBackground(Color.decode("#535870"));
        menu.setBackground(Color.decode("#282B3A"));
        blank.setBackground(Color.decode("#282B3A"));
        tab.setBackground(Color.decode("#535870"));
        //change buton Icon
        Icon i1 = new ImageIcon("C:\\Users\\mansu\\Downloads\\room.png");
        pg1.setIcon(i1);
        pg2.setIcon(new ImageIcon("C:\\Users\\mansu\\Downloads\\create-order.png"));
        pg3.setIcon(new ImageIcon("C:\\Users\\mansu\\Downloads\\room.png"));
        pg4.setIcon(new ImageIcon("C:\\Users\\mansu\\Downloads\\room.png"));
        pg5.setIcon(new ImageIcon("C:\\Users\\mansu\\Downloads\\room.png"));
        ma.setLayout(new BorderLayout(0, 0));
        menu.setPreferredSize(new Dimension(50, 190));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        ma.add(menu, BorderLayout.WEST); 
        ma.add(tab, BorderLayout.CENTER);
        //ยัด panel ลง tab
        tab.addTab("page1",p1);
        tab.addTab("page2",p2);
        tab.addTab("page3",p3);
        tab.addTab("page4",p4);
        tab.addTab("page5",p5);
        // ยัดปุ่มลง menu bar
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
        pg2.setBorderPainted(false);
        pg3.setBorderPainted(false);
        pg4.setBorderPainted(false);
        pg5.setBorderPainted(false);
        ma.setSize(1280, 720);
        ma.setVisible(true);
        
        //button action
        pg1.addActionListener(this);
        pg2.addActionListener(this);
        pg3.addActionListener(this);
        pg4.addActionListener(this);
        pg5.addActionListener(this);
    }
    // เปลี่ยนหน้า
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(pg1)){
           tab.setSelectedIndex(0);
        }
        else if(ev.getSource().equals(pg2)){
           tab.setSelectedIndex(1);
        }
        else if(ev.getSource().equals(pg3)){
           tab.setSelectedIndex(2);
        }
        else if(ev.getSource().equals(pg4)){
           tab.setSelectedIndex(3);
        }
        else if(ev.getSource().equals(pg5)){
           tab.setSelectedIndex(4);
        }
    }
    
    }

