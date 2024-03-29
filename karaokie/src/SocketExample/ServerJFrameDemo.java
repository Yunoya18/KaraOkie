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

/**
 * localhost, 9999
*/

public class ServerJFrameDemo implements ActionListener {
    private JFrame fr;
    private JTextField tf;
    private JButton bn_accept;
    
    public ServerJFrameDemo() {
        fr = new JFrame();
        tf = new JTextField("call staff : ");
        bn_accept = new JButton("accept");
        
        fr.setLayout(new FlowLayout());
        fr.add(tf);
        fr.add(bn_accept);
        
        tf.setEditable(false);
        
        bn_accept.addActionListener(this);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200, 200);
        fr.setVisible(true);
        
        // socket \\
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
            
//            outToClient.writeBytes("d");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //.........\\
    }    
    
    public void callStaff() {
        tf.setText("call staff : true");
    }
    
    
    public static void main(String[] args) {
//        new ClientJFrameDemo(this);
        new ServerJFrameDemo(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bn_accept)) {
//            try (ServerSocket welcomeSocket = new ServerSocket(9999);
//            Socket connectionSocket = welcomeSocket.accept();
//            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());) {
//
//                System.out.println("server connected");
//
//                String n = inFromClient.readLine();
//                System.out.println(n + " is from client");
//    //            System.out.println(inFromClient.readLine() + " is from client");
//
//                if (n.equals("c")) {
//                    System.out.println("ccccccc");
//                    callStaff();
//                }
//
//    //            outToClient.writeBytes("d");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }            
        }
    }
}    

