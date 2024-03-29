package karaokie.Menu;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import karaokie.room.Controller;

public class ImportMenu {

    public static void main(String argv[]) {

         try {
            Socket socket = new Socket("localhost",6789);
            
            InputStream inputStream = socket.getInputStream();
            BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("menu.dat"));
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            
            fileOutputStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ImportMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
           

   
        }
    
