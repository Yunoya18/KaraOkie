package SocketExample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author noey
 */

public class ClientJFrameDemo implements ActionListener {
    private JFrame fr;
    private JButton bn_alert;
    private ServerJFrameDemo x;
    
    private String testtxt = "c";
    
    public ClientJFrameDemo(/*ServerJFrameDemo x*/) {
        fr = new JFrame();
        bn_alert = new JButton("call staff press here");
        
//        this.x = x;
        
        fr.setLayout(new FlowLayout());
        fr.add(bn_alert);
        
        bn_alert.addActionListener(this);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200, 200);
        fr.setVisible(true);
            
            // socket \\
//        try (Socket clientSocket = new Socket("localhost", 9999);
//        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
//
//            System.out.println("client connected");
//
////            outToServer.writeBytes(testtxt);
//
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
            //........\\
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bn_alert)) {
            
            /**
             *  not socket : call staff test
             *  run on ServerJFrameDemo.java
             */
//            x.callStaff();
            /******************************/
            
            // socket \\
            try (Socket clientSocket = new Socket("localhost", 9999);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                
                System.out.println("client connected");
                
                outToServer.writeBytes(testtxt);
//                System.out.println(inFromServer.readLine() + "client");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //........\\
            
            
        }
    }    
    public static void main(String[] args) {
        new ClientJFrameDemo();
    }
}
