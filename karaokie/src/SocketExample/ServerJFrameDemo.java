package SocketExample;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author noey
 */
public class ServerJFrameDemo {
    private JFrame fr;
    private JTextField tf;
    
    public ServerJFrameDemo() {
        fr = new JFrame();
        tf = new JTextField("call staff : ");
        
        fr.setLayout(new FlowLayout());
        fr.add(tf);
        
        tf.setEditable(false);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200, 200);
        fr.setVisible(true);
//        new ClientJFrameDemo(this);
        
        try (ServerSocket welcomeSocket = new ServerSocket(9999);
        Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());) {
            
            System.out.println("server connected");
            
            String n = inFromClient.readLine();
            System.out.println(n + " is from client");
//            System.out.println(inFromClient.readLine() + " is from client");
            
            if (n.equals("c")) {
                System.out.println("ccccccc");
                callStaff();
            }
//           connectionSocket.close();
//           welcomeSocket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    
    
    public void callStaff() {
        tf.setText("call staff : true");
    }
    
    public static void main(String[] args) {
//        new ClientJFrameDemo(this);
        new ServerJFrameDemo(); 
    }
}    

