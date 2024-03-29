/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketExample;

/**
 *
 * @author noey
 */

/**
 * thissssss oneeeeee
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWithNoButton implements ActionListener {
    private ServerSocket server;
    private Socket clientSocket;
    private DataInputStream input;
    private DataOutputStream output;

    private JFrame frame;
    private JTextField tf;
    private JButton bn_accept;
//    private JButton sendAlertButton;

    public ServerWithNoButton(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started. Waiting for a client...");

            clientSocket = server.accept();
            System.out.println("Client connected.");

            input = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            output = new DataOutputStream(clientSocket.getOutputStream());

            initializeUI();
//            setupButtonListener();

            while (true) {
                try {
                    String message = input.readUTF();
                    System.out.println("Received from client: " + message);
                    tf.setText("need staff");
                    


                    // Process the message (e.g., call staff, update UI, etc.)
                    // Implement your logic here
                } catch (EOFException e) {
                    System.out.println("End of stream reached. Client may have disconnected.");
                    break; // Exit the loop if EOFException is caught
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeUI() {
        frame = new JFrame("Server with Button");
        
        tf = new JTextField("-");
        tf.setFont(new Font("Serif", Font.BOLD, 30));
        
        bn_accept = new JButton("accept");
        bn_accept.addActionListener(this);
        
        frame.add(tf, BorderLayout.CENTER);
        frame.add(bn_accept, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

//        sendAlertButton = new JButton("Send Alert to Client");
//        frame.add(sendAlertButton, BorderLayout.CENTER);

        frame.setVisible(true);
    }

//    private void setupButtonListener() {
//        sendAlertButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // When the button is pressed, send an alert message to the client
//                sendMessageToClient("Alert from server: Staff assistance needed!");
//            }
//        });
//    }

//    private void sendMessageToClient(String message) {
//        if (clientSocket != null && clientSocket.isConnected()) {
//            try {
//                output.writeUTF(message);
//                output.flush(); // Ensure the message is sent immediately
//                System.out.println("Sent to client: " + message);
//            } catch (IOException e) {
//                System.out.println("Error sending message to client: " + e.getMessage());
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Client socket is closed or not connected.");
//        }
//    }


    public static void main(String[] args) {
        ServerWithNoButton server = new ServerWithNoButton(5000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bn_accept)) {
            tf.setText("-");
        }
    }
}

