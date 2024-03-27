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
    public fillFood(){
        //menu and food
        menu = new Menus();

        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(300, 500));
        setResizable(false);
        
        // Panel
        p = new JPanel();
        p.setLayout(new GridLayout(7, 1, 0, 15));
        p.setPreferredSize(new Dimension(250, 230));
        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setPreferredSize(new Dimension(250, 30));
        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 8));
        p3.setPreferredSize(new Dimension(250, 200));
        
        // input data        
        // button
        b1 = new JButton("Done");
        b2 = new JButton();
        b2.setPreferredSize(new Dimension(18, 18));
        i = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/search_3031293.png");
        im = i.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        i2 = new ImageIcon(im);
        b2.setIcon(i2);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setBackground(Color.decode("#EEEEEE"));
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
        tf2 = new JTextField();
        l1 = new JLabel("Name");
        l5 = new JLabel("Category");
        String[] ty = {"Food", "Snack", "Drinks"};
        cb = new JComboBox(ty);
        l2 = new JLabel("Price");
        l3 = new JLabel("Image");
        l4 = new JLabel("Insert Image");
        l4.setPreferredSize(new Dimension(200, 25));
        show = new JLabel();
        show.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        show.setPreferredSize(new Dimension(100, 100));
        
        p.add(l1);
        p.add(tf1);
        p.add(l5);
        p.add(cb);
        p.add(l2);
        p.add(tf2);
        p.add(l3);
        p2.add(b2);
        p2.add(l4);
        p3.add(p2);
        p3.add(show);
        p3.add(b1);
        
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
