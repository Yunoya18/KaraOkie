package karaokie.room;

import java.util.*;
import java.io.*;
import karaokie.Menu.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static karaokie.Menu.Menus.map;
import karaokie.*;

public class Controller {

    private static int Room_count = 0;
    private static Map<String, ArrayList<Food>> map;
    private static Map<String, Map<Food, Integer>> roomMenu = new HashMap<>();
    private static ArrayList<room> room = new ArrayList<>();
    public static roompage rp;
    public static JPanel p = new JPanel();
    public static main main = new main();
    
    public static boolean del;

    // Socket
    public static void InFromClient() {

        try (ServerSocket welcomeSocket = new ServerSocket(1234)) {

            Socket connectionSocket = welcomeSocket.accept();
            ObjectInputStream oin = new ObjectInputStream(connectionSocket.getInputStream());

            // Read the serialized data from the client
            roomMenu = (Map<String, Map<Food, Integer>>) oin.readObject();
            System.out.println("Received map from client: " + roomMenu);

            oin.close();
            connectionSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void OutToClient() {
        try (ServerSocket serverSocket = new ServerSocket(6789)) {
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
                roomMenu = (Map<String, Map<Food, Integer>>) oin.readObject();

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
        Controller.renew("pg1");
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
    
    public static void CreateBigRoom2() {
        addRoom(new big_room2(Room_count));
    }

    public static void renew(String name){
        main.renew(name);
    }
    
    public static int getRoomSize(){
        return room.size();
    }
    
    // Menu Zone
    public static void setMenu(String room, Food f, int i) {
        HashMap<Food, Integer> food = new HashMap<>();
        food.put(f, i);
        
        roomMenu.remove(room);
        roomMenu.put(room, food);
    }

    public static HashMap<Food, Integer> getMenu(String key) {
        return (HashMap<Food, Integer>) roomMenu.get(key);
    }

    public static void sentOrder(String name, int row){
        rp.loadOrder(name, row);
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
                roomMenu = (Map<String, Map<Food, Integer>>) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        }
    }
    
    public static void resetFile(){
        roomMenu = new HashMap<>();
        File file = new File("room.dat");
        file.delete();
    }

    public static void main(String[] args) {

        Thread clientThread = new Thread(() -> {
            OutToClient();
        });
        clientThread.start();
    }

}
