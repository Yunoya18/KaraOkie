/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import karaokie.Menu.*;
/**
 *
 * @author Tiraqmisu
 */
public class fillFood extends JFrame implements ActionListener{
    private Menus menu;
    private Food food;
    private JPanel p, p2, p3;
    private JTextField tf1, tf2;
    private JButton b1, b2;
    private JLabel l1, l2, l3, l4, show, l5;
    private ImageIcon i, i2, i3, i4;
    private Image im, im2, im3;
    private JFileChooser fi;
    private byte[] image;
    private String imagepath = "";
    private File fuyu;
    private JComboBox cb;
    private RoundedPanel tf1rp, cbrp, tf2rp, brp;
    public fillFood(){
        //menu and food
        menu = new Menus();

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(300, 520));
        setResizable(false);
        
        // Panel
        p = new JPanel();
        p.setLayout(new GridLayout(7, 1, 0, 15));
        p.setPreferredSize(new Dimension(250, 270));
        p.setBackground(Color.decode("#A6ADCE"));
        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setPreferredSize(new Dimension(250, 30));
        p2.setBackground(Color.decode("#A6ADCE"));
        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 8));
        p3.setPreferredSize(new Dimension(250, 200));
        p3.setBackground(Color.decode("#A6ADCE"));
        
        // input data        
        // button
        b1 = new JButton("Done");
        b1.setFont(new Font("Montserrat", Font.BOLD, 12));
        b1.setForeground(Color.decode("#282B3A"));
        b1.setBackground(Color.decode("#CFD7FA"));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setPreferredSize(new Dimension(68, 20));
        
        brp = new RoundedPanel(20, 20, 75, 30, Color.decode("#CFD7FA"), 1.0f, 4);
        brp.add(b1);
        
        b2 = new JButton();
        b2.setPreferredSize(new Dimension(18, 18));
        i = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/search_3031293.png");
        im = i.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        i2 = new ImageIcon(im);
        b2.setIcon(i2);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setBackground(Color.decode("#A6ADCE"));
        JButton[] group = new JButton[]{b1, b2};
        for(JButton bt : group){
            bt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e){
                    bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        tf1 = new JTextField();
        tf1.setFont(new Font("Montserrat", Font.BOLD, 12));
        tf1.setForeground(Color.decode("#282B3A"));
        tf1.setPreferredSize(new Dimension(230, 20));
        tf1.setBackground(Color.decode("#CFD7FA"));
        tf1.setBorder(BorderFactory.createEmptyBorder());
        
        tf1rp = new RoundedPanel(20, 20, 240, 50, Color.decode("#CFD7FA"), 1.0f, 2);
        tf1rp.add(tf1);
        
        tf2 = new JTextField();
        tf2.setFont(new Font("Montserrat", Font.BOLD, 12));
        tf2.setForeground(Color.decode("#282B3A"));
        tf2.setPreferredSize(new Dimension(230, 20));
        tf2.setBackground(Color.decode("#CFD7FA"));
        tf2.setBorder(BorderFactory.createEmptyBorder());
        
        tf2rp = new RoundedPanel(20, 20, 240, 50, Color.decode("#CFD7FA"), 1.0f, 2);
        tf2rp.add(tf2);
        
        l1 = new JLabel("Name");
        l1.setFont(new Font("Montserrat", Font.BOLD, 12));
        l1.setForeground(Color.decode("#282B3A"));
        l5 = new JLabel("Category");
        l5.setFont(new Font("Montserrat", Font.BOLD, 12));
        l5.setForeground(Color.decode("#282B3A"));
        String[] ty = {"Food", "Snack", "Drinks"};
        cb = new JComboBox(ty);
        cb.setFont(new Font("Montserrat", Font.BOLD, 12));
        cb.setForeground(Color.decode("#282B3A"));
        cb.setBackground(Color.decode("#CFD7FA"));
        
        l2 = new JLabel("Price");
        l2.setFont(new Font("Montserrat", Font.BOLD, 12));
        l2.setForeground(Color.decode("#282B3A"));
        l3 = new JLabel("Image");
        l3.setFont(new Font("Montserrat", Font.BOLD, 12));
        l3.setForeground(Color.decode("#282B3A"));
        l4 = new JLabel("Insert Image");
        l4.setFont(new Font("Montserrat", Font.BOLD, 12));
        l4.setPreferredSize(new Dimension(200, 25));
        l4.setForeground(Color.decode("#282B3A"));
        show = new JLabel();
        show.setBorder(BorderFactory.createLineBorder(Color.decode("#CFD7FA")));
        show.setPreferredSize(new Dimension(100, 100));
        
        p.add(l1);
        p.add(tf1rp);
        p.add(l5);
        p.add(cb);
        p.add(l2);
        p.add(tf2rp);
        p.add(l3);
        p2.add(b2);
        p2.add(l4);
        p3.add(p2);
        p3.add(show);
        p3.add(brp);
        
        getContentPane().setBackground(Color.decode("#A6ADCE"));
        add(p);
        add(p3);
        setLocation(500, 100);
        pack();
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        cb.addActionListener(this);
        
    }
    public ImageIcon seticon(String m, byte[] i){
        if(m != null){
            i3 = new ImageIcon(m);
        }
        else{
            i3 = new ImageIcon(i);
        }
        im2 = i3.getImage();
        im3 = im2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        i4 = new ImageIcon(im3);
        return i4;
    }
    private void useimage(){
        fi = new JFileChooser();
            fi.setCurrentDirectory(new File("user.dir"));
            FileNameExtensionFilter fil = new FileNameExtensionFilter("All pic", "png", "jpg", "jpeg");
            fi.addChoosableFileFilter(fil);
            int a = fi.showSaveDialog(null);
            if(a == JFileChooser.APPROVE_OPTION){
                l4.setText(fi.getSelectedFile().getAbsolutePath());
                fuyu = fi.getSelectedFile();
                String p = fuyu.getAbsolutePath();
                show.setIcon(seticon(p, null));
            }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(b1)){
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !l4.getText().equals("Insert Image")){
                addFood.addRow(new Object[]{
                show.getIcon(),
                tf1.getText(),
                cb.getSelectedItem(),
                tf2.getText()+" THB",        
                });
                menu.addMenu(new Food(tf1.getText(), show.getIcon(), Double.parseDouble(tf2.getText()), (String) cb.getSelectedItem()));
                dispose();
            }
            else if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || l4.getText().equals("Insert Image")){
                JOptionPane.showMessageDialog(this, "Please fill in all required information.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource().equals(b2)){
            useimage();
        }
    }
    public static void main(String[] args) {
        new fillFood();
    }
}
