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
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import javax.swing.*;


public class mainUser extends JPanel implements ActionListener{
    // private JFrame ma;
    private JDesktopPane side;
    private JInternalFrame inf;
    private JPanel menu, blank, blank2, p1, p2, tab;
    private JButton pg1, pg2, pg3;
    private CardLayout cardlayout;
    private JLabel txt1, txt2;
    private cartUser cu;
    
    // socketalert ssaan
    private static final String SERVER_ADDRESS = "26.64.54.150";
    private static final int SERVER_PORT = 5000;
    
    private Socket socket;
    private DataOutputStream out;  
     
    public mainUser(){
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Bold.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        
        // ma = new JFrame("karaOkie");
        menu = new JPanel();
        cardlayout = new CardLayout();
        tab = new JPanel(cardlayout);
        blank = new JPanel();
        blank2 = new JPanel();
        pg2 = new JButton();
        pg3 = new JButton();
        pg1 = new JButton();
        p1 = new JPanel();
        p2 = new JPanel();
        txt1 = new JLabel("page1");
        txt2 = new JLabel("page2");
        
        cu = new cartUser();        //9999
        
        orderUser pm = new orderUser();

        //set backgroundcolor and foreground color
        p1.setBackground(Color.decode("#535870"));
        p2.setBackground(Color.decode("#535870"));
        tab.setBackground(Color.decode("#535870"));
        menu.setBackground(Color.decode("#282B3A"));
        blank.setBackground(Color.decode("#282B3A"));
        blank2.setBackground(Color.decode("#282B3A"));
        txt1.setForeground(Color.WHITE);
        txt2.setForeground(Color.WHITE);
        
        //test changing page
        p1.add(txt1);
        p2.add(txt2);
        
        //set Icon Image
        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/menu.png");
        Image img1 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon1 = new ImageIcon(img1);
        ImageIcon i2 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/grocery-store.png");
        Image img2 = i2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon2 = new ImageIcon(img2);
        ImageIcon i3 = new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/user.png");
        Image img3 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon icon3 = new ImageIcon(img3);
        pg1.setIcon(icon1);
        pg2.setIcon(icon2);
        pg3.setIcon(icon3);
        
        //set mainframe background
        setLayout(new BorderLayout(0, 0));
        
        menu.setPreferredSize(new Dimension(50, 190));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        //add components to mainframe
        add(menu, BorderLayout.WEST); 
        add(tab, BorderLayout.CENTER);
        
        //add panel to tab
        tab.add(pm, "pg1");
        
        
        //insert button in menu bar
        menu.add(blank);
        menu.add(pg1);
        menu.add(pg2);
        menu.add(blank2);
        menu.add(pg3);
        blank.setPreferredSize(new Dimension(30, 30));
        blank2.setPreferredSize(new Dimension(30, 420));
        
        //set button size
        pg1.setPreferredSize(new Dimension(50, 50));
        pg2.setPreferredSize(new Dimension(50, 50));
        pg3.setPreferredSize(new Dimension(50, 50));
        pg1.setBackground(Color.decode("#282B3A"));
        pg2.setBackground(Color.decode("#282B3A"));
        pg3.setBackground(Color.decode("#282B3A"));
        
        //delete button border and focus border
        pg1.setBorderPainted(false);
        pg1.setFocusPainted(false);
        pg2.setBorderPainted(false);
        pg2.setFocusPainted(false);
        pg3.setBorderPainted(false);
        pg3.setFocusPainted(false);
        //button array for configured use
        JButton[] group = new JButton[]{pg1, pg2, pg3};
        
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
                        }
                        else if(e.getSource().equals(pg3)){
                            ImageIcon hoverIcon = new ImageIcon(i3.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
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
                    }
                });
        }
        //configured button not to have white filter when pressing
        UIManager.getLookAndFeelDefaults().put("Button.select", new Color(0, 0, 0, 0));
        
        setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        // setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //button action
        pg1.addActionListener(this);
        pg2.addActionListener(this);
        pg3.addActionListener(this);
        
        // socketalert ssaan 0000
        socketClientFirstSetupConnection();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(pg1)){
           cardlayout.show(tab, "pg1");
        }
        else if(ev.getSource().equals(pg2)){
//            cu = new cartUser(); 9999 (moved to default constructor cause other have to use)
        cu.updateCartOrder();
            tab.add(cu, "pg2");
           cardlayout.show(tab, "pg2");
            System.out.println("2"); 
        }
        else if(ev.getSource().equals(pg3)){
           int resp = JOptionPane.showConfirmDialog(this, "Are you sure that you want to ask for staff assistance?", "Confirmation", JOptionPane.YES_NO_OPTION);
           if(resp == JOptionPane.YES_OPTION){
                setDefaultText<String, String> txt = new setDefaultText<>("Alert", Loginpage.nam);
                JOptionPane.showMessageDialog(null, txt);
               // alert the staff
               // ssaan 0000
                System.out.println("getRoomFromCart : " + cu.getRoomFromCart()); // 9999
                socketSendAlertToStaff("" + Loginpage.nam);        // 2222        

           }
        }
    }
    
    //== socket alert the staff ssaan 0000 ========================================================================================= \\
    public void socketClientFirstSetupConnection() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
      
    
    public void socketSendAlertToStaff(String message) { 
        try (Socket clientSocket = new Socket("26.26.134.224", 6996);
             OutputStream outputStream = clientSocket.getOutputStream();
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {


            outputStreamWriter.write(message);
            outputStreamWriter.flush(); 

            System.out.println("Message sent successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    //========================================================================================= \\
    
    public static void main(String[] args) {
        new mainUser();   
    }
}
