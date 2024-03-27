/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginExample;

/**
 *
 * @author noey
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDemo extends JFrame implements ActionListener {
    JButton submitButton;
    JPanel panel;
    JLabel userLabel, passwordLabel;
    final JTextField  textField1, textField2;

    LoginDemo() {
        // Username Label
        userLabel = new JLabel();
        userLabel.setText("Username:");
        textField1 = new JTextField(15);

        // Password Label
        passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        textField2 = new JPasswordField(15);
        
        // Submit Button
        submitButton = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(userLabel);
        panel.add(textField1);
        panel.add(passwordLabel);
        panel.add(textField2);
        panel.add(submitButton);
        add(panel, BorderLayout.CENTER);
        submitButton.addActionListener(this);
        setTitle("Login Form");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();        // get user entered username from the textField1
        String passValue = textField2.getText();        // get user entered password from the textField2

        // The below code simulates a database by using a simple if statement
        if (userValue.equals("user") && passValue.equals("password")) {
            // If the user entered values are correct, show a new frame
            NextPage page = new NextPage();
            page.setVisible(true);
            JLabel label = new JLabel("Welcome:" + userValue);
            page.getContentPane().add(label);
        } else {
            System.out.println("Please enter valid username and password");
        }
    }
}



// Run the login demo


