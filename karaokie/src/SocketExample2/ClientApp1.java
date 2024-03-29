/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketExample2;

/**
 *
 * @author noey
 */

/**
 * write like what oop teach
 * ClientApp.java modified
 * test with ServerWithButton.java
 */

import SocketExample.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp1 implements ActionListener {
    private static final String SERVER_ADDRESS = "localhost"; // Replace with the actual server IP
    private static final int SERVER_PORT = 5000; // Replace with the actual server port

    private JFrame frame;
    private JButton callStaffButton;
    private Socket socket;
    private DataOutputStream out;

    public ClientApp1() {
        // initializeUI();
        frame = new JFrame("Karaoke Room Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        callStaffButton = new JButton("Call Staff");
        frame.add(callStaffButton, BorderLayout.CENTER);

        frame.setVisible(true);
        
        // setupButtonListener();
        callStaffButton.addActionListener(this); // continue in actionPerformed()
        
        // setupConnection();
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    private void sendMessageToServer(String message) {
        if (socket != null && socket.isConnected()) {
            try {
                // Send the message to the server
                out.writeUTF(message);
                out.flush(); // Ensure the message is sent immediately
                System.out.println("Message sent to server: " + message);
            } catch (IOException e) {
                System.out.println("Error sending message to client: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Client socket is closed or not connected.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        sendMessageToServer("Staff assistance needed!");
    }    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientApp1());
    }
}

