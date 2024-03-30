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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import karaokie.Menu.Food;
import karaokie.Menu.roomMenu;
public class orderUser extends JPanel implements ActionListener{
    private JButton b1, b2, b3, b4;
    private JScrollPane sc, sc2, sc3, sc4;
    private JPanel p1, but, all, fo, sn, dr, ppic, pname, pprice, pbut;
    private RoundedPanel menu;
    private JLabel pic, name, price;
    private addFood af;
    private CardLayout cl;
    private fillFood ff;
    private String ty;
    private Map<String, ArrayList<Food>> map;
    private roomMenu room;
    public orderUser(){
        room = new roomMenu();
        setBackground(Color.decode("#535870"));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        b1 = new JButton("All");
        // these button will setvisible(true) when the column categories in the table from addfood has them, if not these button will setvisible(false)
        b2 = new JButton("Food");
        b3 = new JButton("Snack");
        b4 = new JButton("Drinks");
        b1.setBackground(Color.decode("#535870"));
        b2.setBackground(Color.decode("#535870"));
        b3.setBackground(Color.decode("#535870"));
        b4.setBackground(Color.decode("#535870"));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        b4.setBorderPainted(false);
        b4.setFocusPainted(false);
        b1.setForeground(Color.decode("#A6ADCE"));
        b2.setForeground(Color.decode("#A6ADCE"));
        b3.setForeground(Color.decode("#A6ADCE"));
        b4.setForeground(Color.decode("#A6ADCE"));
        JButton[] group = new JButton[]{b1, b2, b3, b4};
        for(JButton button : group){
            button.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    if(e.getSource().equals(b1)){
                        b1.setForeground(Color.decode("#FF6CDF"));
                    }
                    else if(e.getSource().equals(b2)){
                        b2.setForeground(Color.decode("#FF6CDF"));
                    }
                    else if(e.getSource().equals(b3)){
                        b3.setForeground(Color.decode("#FF6CDF"));
                    }
                    else if(e.getSource().equals(b4)){
                        b4.setForeground(Color.decode("#FF6CDF"));
                    }
                    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        if(e.getSource().equals(b1)){
                            b1.setForeground(Color.decode("#A6ADCE"));
                        }
                        else if(e.getSource().equals(b2)){
                            b2.setForeground(Color.decode("#A6ADCE"));
                        }
                        else if(e.getSource().equals(b3)){
                            b3.setForeground(Color.decode("#A6ADCE"));
                        }
                        else if(e.getSource().equals(b4)){
                            b4.setForeground(Color.decode("#A6ADCE"));
                        }
                }
            });
        }
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        cl = new CardLayout();
        p1 = new JPanel();
        p1.setLayout(cl);
        p1.setBackground(Color.decode("#535870"));
        p1.setPreferredSize(new Dimension(1100, 600));
    
        but = new JPanel(new FlowLayout(FlowLayout.CENTER));
        but.setBackground(Color.decode("#535870"));
        but.setPreferredSize(new Dimension(1220, 40));
        but.add(b1);
        but.add(b2);
        but.add(b3);
        but.add(b4);

//      each type
        all = new JPanel(new FlowLayout(FlowLayout.CENTER, 13, 13));
        all.setBackground(Color.decode("#535870"));
        sc = new JScrollPane(all);
        sc.setPreferredSize(new Dimension(1050, 60));
        sc.setBorder(BorderFactory.createLineBorder(Color.decode("#535870")));
        p1.add(sc, "all");
        
        fo = new JPanel();
        fo.setBackground(Color.decode("#535870"));
        sc2 = new JScrollPane(fo);
        sc2.setPreferredSize(new Dimension(1085, 60));
        sc2.setBorder(BorderFactory.createLineBorder(Color.decode("#535870")));
        p1.add(sc2, "food");
        
        sn = new JPanel();
        sn.setBackground(Color.decode("#535870"));
        sc3 = new JScrollPane(sn);
        sc3.setPreferredSize(new Dimension(1085, 60));
        sc3.setBorder(BorderFactory.createLineBorder(Color.decode("#535870")));
        p1.add(sc3, "snack");
        
        dr = new JPanel();
        dr.setBackground(Color.decode("#535870"));
        sc4 = new JScrollPane(dr);
        sc4.setPreferredSize(new Dimension(1085, 60));
        sc4.setBorder(BorderFactory.createLineBorder(Color.decode("#535870")));
        p1.add(sc4, "drinks");
        add(but);
        add(p1);
        setVisible(true);
    }
    
//  for create a new menu
//  need to check the categories before add to panel
//  fo is Food, sn is Snack and dr is Drinks 
    public void newMenu(ImageIcon i, String n, String p, JPanel j,String type){
        menu = new RoundedPanel(20, 20, 350, 550, Color.decode("#282B3A"), 1.0f, 21);
        
        ppic = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pprice = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pname = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pbut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ppic.setPreferredSize(new Dimension(300, 300));
        pname.setPreferredSize(new Dimension(300, 50));
        pprice.setPreferredSize(new Dimension(300, 50));
        pbut.setPreferredSize(new Dimension(300, 70));
        ppic.setBackground(Color.decode("#282B3A"));
        pprice.setBackground(Color.decode("#282B3A"));
        pname.setBackground(Color.decode("#282B3A"));
        pbut.setBackground(Color.decode("#282B3A"));

        pic = new JLabel();
        pic.setIcon(i);
        pic.setPreferredSize(new Dimension(300, 300));
        pic.setBorder(BorderFactory.createLineBorder(Color.decode("#535870")));
        
        name = new JLabel();
        name.setText(n);
        name.setFont(new Font("", Font.PLAIN, 30));
        name.setForeground(Color.white);
        
        price = new JLabel();
        price.setText(p);
        price.setFont(new Font("", Font.PLAIN, 30));
        price.setForeground(Color.white);
        
        JButton menub = new JButton("Add");
        menub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog( "How many would you like?", JOptionPane.PLAIN_MESSAGE);
            if (input != null && !input.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(input);
                    
                    room.addMenu(new Food(n,i,Double.parseDouble(p),type),quantity);
                    System.out.println(quantity);
                    System.out.println(n);
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pname, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(pname, "Please enter a quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        ppic.add(pic);
        pname.add(name);
        pprice.add(price);
        pbut.add(menub);
        
        menu.add(ppic);
        menu.add(pname);
        menu.add(pprice);
        menu.add(pbut);
        j.add(menu);
        menub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {                        
                menub.setCursor(new Cursor(Cursor.HAND_CURSOR));                       
            }
            @Override
            public void mouseExited(MouseEvent e) {
                menub.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));                        
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(b1)){
            all.removeAll();

            this.loadMap();
            for (String key : map.keySet()) {
                for (int num = 0; num <= map.get(key).size() - 1; num++) {
                    Icon icon = (Icon) map.get(key).get(num).getImage();
                    String name = (String) map.get(key).get(num).getName();
                    double price = (double) map.get(key).get(num).getPrice();
                    String type = (String) map.get(key).get(num).getType();
                    this.newMenu((ImageIcon) icon, name, String.valueOf(price), all,type);
                }
            }

            cl.show(p1, "all");
        }
        else if(ev.getSource().equals(b2)){
            fo.removeAll();
          
            this.loadMap();
            for (int num = 0; num <= map.get("Food").size() - 1; num++) {
                Icon icon = (Icon) map.get("Food").get(num).getImage();
                String name = (String) map.get("Food").get(num).getName();
                double price = (double) map.get("Food").get(num).getPrice();
                String type = (String) map.get("Food").get(num).getType();
                this.newMenu((ImageIcon) icon, name, String.valueOf(price), fo,type);
            }
            cl.show(p1, "food");
        }
        else if(ev.getSource().equals(b3)){
            sn.removeAll();
 
            this.loadMap();
            for (int num = 0; num <= map.get("Snack").size() - 1; num++) {
                Icon icon = (Icon) map.get("Snack").get(num).getImage();
                String name = (String) map.get("Snack").get(num).getName();
                double price = (double) map.get("Snack").get(num).getPrice();
                String type = (String) map.get("Snack").get(num).getType();
                this.newMenu((ImageIcon) icon, name, String.valueOf(price), sn,type);
                
            }
            cl.show(p1, "snack");
        }
        else if(ev.getSource().equals(b4)){
            dr.removeAll();
           
            this.loadMap();
            for (int num = 0; num <= map.get("Drinks").size() - 1; num++) {
                Icon icon = (Icon) map.get("Drinks").get(num).getImage();
                String name = (String) map.get("Drinks").get(num).getName();
                double price = (double) map.get("Drinks").get(num).getPrice();
                String type = (String) map.get("Drinks").get(num).getType();
                this.newMenu((ImageIcon) icon, name, String.valueOf(price), dr,type);
            }
            cl.show(p1, "drinks");
        }
        else if(ev.getActionCommand().equals("Add")){
            JOptionPane.showInputDialog(this, "", "How many would you like?", JOptionPane.PLAIN_MESSAGE);
        }
    }
        public void loadMap() {
        File file = new File("menu.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("menu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new mainUser();
    }
}
