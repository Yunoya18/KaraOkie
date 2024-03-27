/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginExample;

import javax.swing.JOptionPane;

/**
 *
 * @author noey
 */
public class MainDemo {
    public static void main(String[] args) {
        try {
            LoginDemo frame = new LoginDemo();
            frame.setSize(300, 100);
            frame.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
}
