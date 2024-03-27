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
public class Loginpage extends JPanel implements ActionListener{
    private JPanel left_panel, right_panel, right_cen, empty_pa1, empty_pa2;
    private JTextField username, password;
    private JButton signin;
    private JLabel  app_name, user_img, pass_img;
    
   
    Loginpage(CardLayout cardLayout, Container cardPanel){
        left_panel = new JPanel();
        right_panel = new JPanel();
        username = new JTextField();
        password = new JTextField();
        signin = new JButton();
        right_cen = new JPanel();
        empty_pa1 = new JPanel();
        empty_pa2 = new JPanel();
        app_name = new JLabel("KaraOkie", SwingConstants.RIGHT);
        
        setLayout(new BorderLayout());
        add(left_panel, BorderLayout.WEST);
        add(right_panel, BorderLayout.CENTER);
        
        //set panel size
        left_panel.setPreferredSize(new Dimension(800,0));
        
        
        
        
        //import img
        ImageIcon u = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 61 (1).png");
        Image us = u.getImage().getScaledInstance(350, 60, Image.SCALE_SMOOTH);
        Icon user = new ImageIcon(us);
        ImageIcon s = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 48.png");
        Image si = s.getImage().getScaledInstance(140, 50, Image.SCALE_SMOOTH);
        Icon sign = new ImageIcon(si);
//        ImageIcon p = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 45.png");
//        Image pw = p.getImage().getScaledInstance(110, 90, Image.SCALE_SMOOTH);
//        Icon pass = new ImageIcon(pw);
        user_img = new JLabel(user);
        pass_img = new JLabel(user);
        user_img.setLayout(new FlowLayout(FlowLayout.CENTER,0,25));
        pass_img.setLayout(new FlowLayout(FlowLayout.CENTER,0,25));
        user_img.add(username);
        user_img.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pass_img.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pass_img.add(password);
        signin.setIcon(sign);
        
        signin.addMouseListener(new MouseAdapter(){
            @Override
             public void mouseEntered(MouseEvent e){
                 signin.setCursor(new Cursor(Cursor.HAND_CURSOR));
             }
             @Override
             public void mouseExited(MouseEvent e){
                 signin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
             }
             @Override
             public void mouseClicked(MouseEvent e){
                 if(username.getText().equals("1")){
                     cardLayout.show(cardPanel,"pg3");
                 }
                else{
                 cardLayout.show(cardPanel, "pg2");
                 }
             }
        });
        
        
        
        //add user pass to right
        
        //setLayout
        right_cen.setLayout(new GridLayout(2,1));
        left_panel.setLayout(new BorderLayout());
        right_panel.setLayout(new BorderLayout());
        left_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        empty_pa2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
        
        
        
        
        //add panel
        left_panel.add(app_name, BorderLayout.CENTER);
        right_panel.add(empty_pa1, BorderLayout.NORTH);
        right_panel.add(empty_pa2, BorderLayout.SOUTH);
        right_panel.add(right_cen, BorderLayout.CENTER);
        right_cen.add(user_img);
        right_cen.add(pass_img);
        empty_pa2.add(signin);
        
        //set app_name width height nad layout
        app_name.setPreferredSize(new Dimension(0,100));
        empty_pa1.setPreferredSize(new Dimension(0,250));
        empty_pa2.setPreferredSize(new Dimension(0,250));
        username.setPreferredSize(new Dimension(320,30));
        password.setPreferredSize(new Dimension(320,30));
        signin.setPreferredSize(new Dimension(140,60));
        
        signin.setBorderPainted(false);
        signin.setFocusPainted(false);
        username.setBorder(null);
        password.setBorder(null);
        username.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        
        app_name.setForeground(Color.WHITE);
        app_name.setFont(new Font(app_name.getFont().getName(), Font.BOLD, 60));
        
        //setBackground
        left_panel.setBackground(Color.decode("#171925"));
        right_panel.setBackground(Color.decode("#A6ADCE"));
        right_cen.setBackground(Color.decode("#A6ADCE"));
        empty_pa1.setBackground(Color.decode("#A6ADCE"));
        empty_pa2.setBackground(Color.decode("#A6ADCE"));
        signin.setBackground(Color.decode("#A6ADCE"));
        username.setBackground(Color.decode("#3D4465"));
        password.setBackground(Color.decode("#3D4465"));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(signin)){
        
    }
    }
}
