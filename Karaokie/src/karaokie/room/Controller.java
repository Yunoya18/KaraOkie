package karaokie.room;

import java.util.*;
import java.io.*;
import karaokie.Menu.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static karaokie.Menu.Menus.map;

public class Controller {

    private static int Room_count = 0;
    private static Map<String, ArrayList<Food>> map;
    private static ArrayList<room> room = new ArrayList<>();
    private static ArrayList<roomMenu> roomMenu = new ArrayList<>();
    public static JPanel p = new JPanel();
    public static boolean del;

    // Socket
    public static void InFromClient() {

        try (ServerSocket welcomeSocket = new ServerSocket(6789)) {

            Socket connectionSocket = welcomeSocket.accept();
            ObjectInputStream oin = new ObjectInputStream(connectionSocket.getInputStream());

            // Read the serialized data from the client
            map = (Map<String, ArrayList<Food>>) oin.readObject();
            System.out.println("Received map from client: " + map);

            oin.close();
            connectionSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void OutToClient() {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            Socket socket = serverSocket.accept();

            OutputStream ops = socket.getOutputStream();
            BufferedOutputStream bof = new BufferedOutputStream(ops);
            ObjectOutputStream oos = new ObjectOutputStream(bof);

            File file = new File("menu.dat");
            FileInputStream fin = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fin.read(buffer)) != -1) {
                bof.write(buffer, 0, bytesRead);
            }

            fin.close();

            oos.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ImportMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    
    

    public Controller() {
        // File
        File file_room = new File("room.dat");
        File file_roomMenu = new File("roomMenu.dat");
        if (file_room.exists()) {
            try (FileInputStream fin = new FileInputStream("room.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                room = (ArrayList<room>) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }
        if (file_roomMenu.exists()) {
            try (FileInputStream fin = new FileInputStream("roomMenu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                roomMenu = (ArrayList<roomMenu>) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }

    }

    // Room Zone
    public static void addRoom(room r) {
        room.add(r);
        Room_count++;
    }

    public static void delRoom(int index, room r) {
        p.remove(r);
        room.set(index, null);
    }
    

    public static room getRoom(int index) {
        return room.get(index);
    }

    public static ArrayList<room> getArrayRoom() {
        return room;
    }

    public static void CreateSmallRoom() {
        addRoom(new small_room(Room_count));
    }

    public static void CreateBigRoom() {
        addRoom(new big_room(Room_count));
    }

    // Menu Zone
    public static void setMenu(int index, roomMenu rm) {
        roomMenu.set(index, rm);
    }

    public static roomMenu getMenu(int index) {
        return roomMenu.get(index);
    }

    public static void delMenu(int index) {
        setMenu(index, null);
    }
   
    // File Save
    public static void saveFile() {

        // room
        try (FileOutputStream fout = new FileOutputStream("room.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            oout.writeObject(room);

        } catch (IOException e) {

            e.printStackTrace();
        }

        // roomMenu
        try (FileOutputStream fout = new FileOutputStream("roomMenu.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            oout.writeObject(roomMenu);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    
    public static void openFile() {

        // File
        File file_room = new File("room.dat");
        File file_roomMenu = new File("roomMenu.dat");
        if (file_room.exists()) {
            try (FileInputStream fin = new FileInputStream("room.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {

                room = (ArrayList<room>) oin.readObject();
                Room_count = room.size();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }
        if (file_roomMenu.exists()) {
            try (FileInputStream fin = new FileInputStream("roomMenu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                roomMenu = (ArrayList<roomMenu>) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Thread clientThread = new Thread(() -> {
            OutToClient();
        });
        clientThread.start();
    }

}
