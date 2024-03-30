/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author mansu
 */
import database.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Loginpage extends JPanel{
    private RoundedPanel pa, u, p, b, userl, passl, signinb;
    private JTextField username, password;
    private JButton signin;
    private JLabel bg, user, pass;
    
    Loginpage(CardLayout cardLayout, Container cardPanel){
        
        setLayout(new BorderLayout());
        
        ImageIcon bgimtemp = new ImageIcon(System.getProperty("user.dir") + "/src/karaokie/image/bg.png");
        Image temp = bgimtemp.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon bgim = new ImageIcon(temp);
        bg = new JLabel(bgim);
        bg.setPreferredSize(new Dimension(1280, 720));
        bg.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
        
        pa = new RoundedPanel(20, 20, 500, 330, Color.decode("#11003B"), 0.7f, 20);
        
        userl = new RoundedPanel(20, 20, 450, 30, Color.decode("#11003B"), 0.0f, 0);
        passl = new RoundedPanel(20, 20, 450, 30, Color.decode("#11003B"), 0.0f, 0);
        signinb = new RoundedPanel(20, 20, 450, 50, Color.decode("#11003B"), 0.0f, 0);
        
        user = new JLabel("Username");
        user.setForeground(Color.white);
        user.setFont(new Font("Montserrat", Font.BOLD, 20));
        userl.add(user);
        
        username = new JTextField();
        username.setBackground(Color.decode("#11003B"));
        username.setPreferredSize(new Dimension(200, 48));
        username.setBorder(null);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Montserrat", Font.BOLD, 15));
        
        u = new RoundedPanel(20, 20, 210, 50, Color.decode("#11003B"), 1.0f, 0);
        u.add(username);
        
        pass = new JLabel("Password");
        pass.setForeground(Color.white);
        pass.setFont(new Font("Montserrat", Font.BOLD, 20));
        passl.add(pass);
        
        password = new JTextField();
        password.setBackground(Color.decode("#11003B"));
        password.setPreferredSize(new Dimension(200, 48));
        password.setBorder(null);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Montserrat", Font.BOLD, 15));
        
        p = new RoundedPanel(20, 20, 210, 50, Color.decode("#11003B"), 1.0f, 0);
        p.add(password);
        
        signin = new JButton("Done");
        signin.setPreferredSize(new Dimension(100, 45));
        signin.setBackground(Color.decode("#11003B"));
        signin.setBorderPainted(false);
        signin.setFocusPainted(false);
        signin.setForeground(Color.white);
        signin.setFont(new Font("Montserrat", Font.BOLD, 15));
        
        b = new RoundedPanel(20, 20, 110, 50, Color.decode("#11003B"), 1.0f, 2);
        b.add(signin);
        
        signinb.add(b);
        
        pa.add(userl);
        pa.add(u);
        pa.add(passl);
        pa.add(p);
        pa.add(signinb);
        bg.add(pa);
        add(bg);
        
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
                //if(username.getText().equals("1")){
                //    cardLayout.show(cardPanel,"pg3");
                //}
                //else{
                //    cardLayout.show(cardPanel, "pg2");
                //}
                String role = getConnection.getRole(username.getText(), password.getText());
                if (role == null) {
                    JOptionPane.showMessageDialog(null, "Error");
                } else if (role.equals("user")){
                    cardLayout.show(cardPanel,"pg3");
                } else if (role.equals("admin")){
                   cardLayout.show(cardPanel, "pg2");
                }
             }
        });
    }
}
