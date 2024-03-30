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
import karaokie.room.Controller;

public class main extends JPanel implements ActionListener, WindowListener{
    private JFrame ma;
    private JDesktopPane side;
    private JPanel menu, blank, p1, p2, p3, p4, p5, tab;
    private JButton pg1, pg2, pg3, pg4, pg5;
    private CardLayout cardlayout;
    private JLabel txt1, txt2, txt3, txt4, txt5;
    private roompage pm1;
    private addFood pm2;
    private transaction pm3;
    private stat pm5;
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
        txt1 = new JLabel("page1");
        txt2 = new JLabel("page2");
        txt3 = new JLabel("page3");
        txt4 = new JLabel("page4");
        txt5 = new JLabel("page5");
        
        //set page
        Controller.main = this;
        pm1 = new roompage();
        pm2 = new addFood();
        pm3 = new transaction();
        pm5 = new stat();
        
        
        
        //set backgroundcolor and foreground color
        p1.setBackground(Color.decode("#535870"));
        p2.setBackground(Color.decode("#535870"));
        p3.setBackground(Color.decode("#535870"));
        p4.setBackground(Color.decode("#535870"));
        p5.setBackground(Color.decode("#535870"));
        tab.setBackground(Color.decode("#535870"));
        menu.setBackground(Color.decode("#282B3A"));
        blank.setBackground(Color.decode("#282B3A"));
        txt1.setForeground(Color.WHITE);
        txt2.setForeground(Color.WHITE);
        txt3.setForeground(Color.WHITE);
        txt4.setForeground(Color.WHITE);
        txt5.setForeground(Color.WHITE);
        
        //test changing page
        p1.add(txt1);
        p2.add(txt2);
        p3.add(txt3);
        p4.add(txt4);
        p5.add(txt5);
        
        //set Icon Image
        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/room.png");
        Image img1 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon1 = new ImageIcon(img1);
        ImageIcon i2 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/create-order.png");
        Image img2 = i2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon2 = new ImageIcon(img2);
        ImageIcon i3 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/tips-2.png");
        Image img3 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon3 = new ImageIcon(img3);
        ImageIcon i4 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/membership-card.png");
        Image img4 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon4 = new ImageIcon(img4);
        ImageIcon i5 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/bar-chart.png");
        Image img5 = i5.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        Icon icon5 = new ImageIcon(img5);
        pg1.setIcon(icon1);
        pg2.setIcon(icon2);
        pg3.setIcon(icon3);
        pg4.setIcon(icon4);
        pg5.setIcon(icon5);
        
        //set mainframe background
        setLayout(new BorderLayout(0, 0));
        menu.setPreferredSize(new Dimension(50, 190));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        
        
        //add components to mainframe
        add(menu, BorderLayout.WEST);
        add(tab, BorderLayout.CENTER);
        
        //add other
        
        
        //add panel to tab
        tab.add(pm1 ,"pg1");
        tab.add(pm2, "pg2");
        tab.add(pm3, "pg3");
        tab.add(p4, "pg4");
        tab.add(pm5, "pg5");
        
        //insert button in menu bar
        menu.add(blank);
        menu.add(pg1);
        menu.add(pg2);
        menu.add(pg3);
        menu.add(pg4);
        menu.add(pg5);
        blank.setPreferredSize(new Dimension(30, 30));
        
        //set button size
        pg1.setPreferredSize(new Dimension(50, 50));
        pg2.setPreferredSize(new Dimension(50, 50));
        pg3.setPreferredSize(new Dimension(50, 50));
        pg4.setPreferredSize(new Dimension(50, 50));
        pg5.setPreferredSize(new Dimension(50, 50));
        pg1.setBackground(Color.decode("#282B3A"));
        pg2.setBackground(Color.decode("#282B3A"));
        pg3.setBackground(Color.decode("#282B3A"));
        pg4.setBackground(Color.decode("#282B3A"));
        pg5.setBackground(Color.decode("#282B3A"));
        
        
        //delete button border and focus border
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
        
        //button array for configured use
        JButton[] group = new JButton[]{pg1, pg2, pg3, pg4, pg5};
        
        //change cursor and make icon bigger when hover
        for(JButton button : group){
              button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(e.getSource().equals(pg1)){
                            ImageIcon hoverIcon = new ImageIcon(i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg2)){
                            ImageIcon hoverIcon = new ImageIcon(i2.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                            
                            pm2.reRow();
                            pm2.windowOpened(null);
                            
                        }
                        else if(e.getSource().equals(pg3)){
                            ImageIcon hoverIcon = new ImageIcon(i3.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg4)){
                            ImageIcon hoverIcon = new ImageIcon(i4.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        else if(e.getSource().equals(pg5)){
                            ImageIcon hoverIcon = new ImageIcon(i5.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
                            button.setIcon(hoverIcon);
                        }
                        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                       
                    }


                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        if(e.getSource().equals(pg1)){
                            button.setIcon(icon1);
                        }
                        else if(e.getSource().equals(pg2)){
                            button.setIcon(icon2);
                        }
                        else if(e.getSource().equals(pg3)){
                            button.setIcon(icon3);
                        }
                        else if(e.getSource().equals(pg4)){
                            button.setIcon(icon4);
                        }
                        else if(e.getSource().equals(pg5)){
                            button.setIcon(icon5);
                        }
                    }
                });
    
        }
        //configured button not to have white filter when pressing
        UIManager.getLookAndFeelDefaults().put("Button.select", new Color(0, 0, 0, 0));
        
         
        
//        ma.setSize(1280, 720);
        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
        
        
        
        //button action
        pg1.addActionListener(this);
        pg2.addActionListener(this);
        pg3.addActionListener(this);
        pg4.addActionListener(this);
        pg5.addActionListener(this);
        
//        setResizable(false);
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
//    public static void main(String[] args) {
//        try {
//            String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
//            UIManager.setLookAndFeel(systemLookAndFeelClassName);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        new main();
//    }

    public void sentOpen(){
        pm1.loadRoomData("All");
        
    }
    
    public void sentClosing(){
        
    }

    public void renew(String name){
        cardlayout.show(tab, "pg4");
        cardlayout.show(tab, name);
    }
    
    public static void main(String[] args) {
        new main();
    }
    
    // ssaan 0000
    public void addDown(String message) { // mp.addDown() in karaokie_main
        pm1.addDown(message);
    }     

    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
       
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
       
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}

 

