package karaokie.Menu;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static karaokie.Menu.Menus.map;
import karaokie.room.Controller;

public class ImportMenu {

    public static Map<String, ArrayList<Food>> map;

    public ImportMenu() {
        map = new HashMap<>();
    }

    public static void imp() {

        try {
            Socket socket = new Socket("localhost", 6789);

            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            ObjectInputStream ois = new ObjectInputStream(bis);

            map = (Map<String, ArrayList<Food>>) ois.readObject();
            
            try (FileOutputStream fout = new FileOutputStream("recave.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

                oout.writeObject(map);
                System.out.println("saverecavefile");
                System.out.println(map);
            } catch (IOException e) {

                e.printStackTrace();
            }

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ImportMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImportMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
