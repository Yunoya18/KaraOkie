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
    private RoundedPanel pa;
    private JTextField username, password;
    private JButton signin;
    private JLabel bg;
    
    Loginpage(CardLayout cardLayout, Container cardPanel){
        username = new JTextField();
        password = new JTextField();
        signin = new JButton();
        
        setLayout(new BorderLayout());
        
        //set panel size
        
        //import img
        ImageIcon s = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Group 48.png");
        Image si = s.getImage().getScaledInstance(140, 50, Image.SCALE_SMOOTH);
        Icon sign = new ImageIcon(si);
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
        
        
        //set app_name width height nad layout
        username.setPreferredSize(new Dimension(320,30));
        password.setPreferredSize(new Dimension(320,30));
        signin.setPreferredSize(new Dimension(140,60));
        
        signin.setBorderPainted(false);
        signin.setFocusPainted(false);
        username.setBorder(null);
        password.setBorder(null);
        username.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        
        //setBackground
        signin.setBackground(Color.decode("#A6ADCE"));
        username.setBackground(Color.decode("#3D4465"));
        password.setBackground(Color.decode("#3D4465"));
        
        ImageIcon bgimtemp = new ImageIcon(System.getProperty("user.dir") + "/src/karaokie/image/bg.png");
        Image temp = bgimtemp.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon bgim = new ImageIcon(temp);
        bg = new JLabel(bgim);
        bg.setPreferredSize(new Dimension(1280, 720));
        bg.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
        
        
        pa = new RoundedPanel(20, 20, 500, 330, Color.decode("#11003B"), 0.7f);
        
        
        
        
        bg.add(pa);
        add(bg);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(signin)){
        
        }
    }
}
