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

public class Controller implements Runnable {

    private static int Room_count = 0;
    private static Map<String, ArrayList<Food>> map;
    private static Map<String, Map<Food, Integer>> roomMenu = new HashMap<>();
    private static ArrayList<room> room = new ArrayList<>();
    public static roompage rp;
    public static transaction ts;
    public static JPanel p = new JPanel();
    public static main main = new main();

    public static boolean del;

    // Socket
    public static void InFromClient() {
        System.out.println("openport 1234");
        try {
            ServerSocket welcomeSocket = new ServerSocket(1234);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                ObjectInputStream oin = new ObjectInputStream(connectionSocket.getInputStream());

                // Read the serialized data from the client
                Map<String, Map<Food, Integer>> inmap = (Map<String, Map<Food, Integer>>) oin.readObject();

                System.out.println(inmap + "deafaaw sforom svcerve");
                for (String key : inmap.keySet()) {

                    // first order
                    Map<Food, Integer> tempRoom = (HashMap<Food, Integer>) roomMenu.get(key); //do plus                        } catch (NullPointerException e){
                    Map<Food, Integer> tempinmap = (Map<Food, Integer>) inmap.get(key);

                    if (tempRoom == null) {
                        tempRoom = new HashMap<>();
                    }

//                    roomMenu.put(key, tempRoom);

                    // Smart 100%
                    for (Food f : tempRoom.keySet()) {
                        for (Food f1 : tempinmap.keySet()) {
                            System.out.println(f.getName() + "       " + f1.getName());
                            if (f.getName().equals(f1.getName())) {

                                tempRoom.put(f, tempRoom.get(f) + tempinmap.get(f1));
//                                tempinmap.remove(f1);
                            }
                        }
                    }

                    for (Food f1 : tempinmap.keySet()) {
                        boolean make = true;
                        for (Food f : tempRoom.keySet()) {
                            if (f1.getName().equals(f.getName())) {
                                make = false;
                            }
                        }
                        if (make) {
                            tempRoom.put(f1, tempinmap.get(f1));
                        }

                    }

                    // Delete equals data
//                    checkequalsClass(tempRoom, tempinmap);
                    roomMenu.put(key, tempRoom);
                }

                System.out.println("Received map from client: " + roomMenu);

                oin.close();
                connectionSocket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void OutToClient() {
        System.out.println("openserver 6789");
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("openserver");
            while (true) {
                Socket socket = serverSocket.accept();

                //loadmap
                File file = new File("menu.dat");
                if (file.exists()) {
                    try (FileInputStream fin = new FileInputStream("menu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                        map = (Map) oin.readObject();
                        System.out.println(map);
                    } catch (IOException | ClassNotFoundException e) {

                        e.printStackTrace();
                    }
                } else {
                    map.put("Food", new ArrayList<Food>());
                    map.put("Snack", new ArrayList<Food>());
                    map.put("Drinks", new ArrayList<Food>());
                }
                //loadmap
                OutputStream ops = socket.getOutputStream();
                BufferedOutputStream bof = new BufferedOutputStream(ops);
                ObjectOutputStream oos = new ObjectOutputStream(bof);

                oos.writeObject(map);
                System.out.println("menustran");
                oos.close();
                socket.close();
                System.out.println("close server");
            }
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
//        if (file_roomMenu.exists()) {
//            try (FileInputStream fin = new FileInputStream("roomMenu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
//                roomMenu = (Map<String, Map<Food, Integer>>) oin.readObject();
//
//            } catch (IOException | ClassNotFoundException e) {
//
//                e.printStackTrace();
//            }
//        }

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

    public static void renew(String name) {
        main.renew(name);
    }

    public static int getRoomSize() {
        return room.size();
    }

    public static void reCard(String s1, String s2) {
        rp.reCard(s1, s2);
    }

    // Menu Zone
    public static void setMenu(Map<String, Map<Food, Integer>> temp) {
//        HashMap<Food, Integer> food = new HashMap<>();
//        food.put(f, i);
//
//        roomMenu.remove(room);
//        roomMenu.put(room, food);

        int count = 0;
        ts.reOrder();
        for (String key : roomMenu.keySet()) {
            roomMenu.put(key, roomMenu.get(key));

            // show Order in transaction
            ts.addOrder(key);

            for (Map<Food, Integer> f : roomMenu.values()) {
                for (Integer foodCount : f.values()) {
                    count += 1;
                }
            }
            System.out.println("Count = " + count);
            sentOrder(key, roomMenu.get(key), count);
//                rp.loadOrder(new showorder(key, temp.get(key), count));

        }
    }

    public static HashMap<Food, Integer> getMenu(String key) {
        return (HashMap<Food, Integer>) roomMenu.get(key);
    }

    public static void sentOrder(String name, Map<Food, Integer> f, int row) {
        rp.loadOrder(new showorder(name, f, row));

    }

    public static int getOrderSize() {
        int count = 0;
        for (String key : roomMenu.keySet()) {
            count += 1;
        }
        return count;
    }

    public static Map<String, Map<Food, Integer>> getRoomMenuMap() {
        return roomMenu;
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
//        try (FileOutputStream fout = new FileOutputStream("roomMenu.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {
//
//            oout.writeObject(roomMenu);
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
    }

    public static void saveFileNULL() {

        // room
        try (FileOutputStream fout = new FileOutputStream("room.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            Controller.room = new ArrayList<>();
            oout.writeObject(room);

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
//        if (file_roomMenu.exists()) {
//            try (FileInputStream fin = new FileInputStream("roomMenu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
//                roomMenu = (Map<String, Map<Food, Integer>>) oin.readObject();
//
//            } catch (IOException | ClassNotFoundException e) {
//
//                e.printStackTrace();
//            }
//        }
    }

    public void loadMap() {
        File file = new File("menu.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("menu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();
                System.out.println(map);
            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        } else {
            map.put("Food", new ArrayList<Food>());
            map.put("Snack", new ArrayList<Food>());
            map.put("Drinks", new ArrayList<Food>());
        }
    }

    public static void resetFile() {
        roomMenu = new HashMap<>();
        File file = new File("room.dat");
        file.delete();
    }

    public static int checkequals(String name, Map<Food, Integer> m) {
        try {
            for (Food f : m.keySet()) {
                if (f.getName().equals(name)) {
                    return m.get(f);
                }
            }
            return 0;
        } catch (NullPointerException e) {
            return 0;
        }

    }

    public static void checkequalsClass(Map<Food, Integer> tempRoom, Map<Food, Integer> tempinmap) {
        for (Food f : tempRoom.keySet()) {
            for (Food f1 : tempRoom.keySet()) {
                if (f.getName().equals(f1.getName())) {

                    if (tempRoom.get(f) > tempRoom.get(f1)) {
                        tempRoom.remove(f1);
                    } else if (tempRoom.get(f) < tempRoom.get(f1)) {
                        tempRoom.remove(f);
                    }
                }
            }
        }
    }

//
//    public static void main(String[] args) {
//        Thread clientThread = new Thread(() -> {
//            OutToClient();
//        });
//        clientThread.start();
//    Map<String, Map<Food, Integer>> t1 = new HashMap<>();
//    Map<Food, Integer> f1 = new HashMap<>();
//    Map<Food, Integer> f2 = new HashMap<>();
//    
//    f1.put(new Food("Teen", null, 100, "Food"), 3);
//    f1.put(new Food("Teen1", null, 100, "Food"), 2);
//    
//    f2.put(new Food("ka", null, 100, "Food"), 1);
//    f2.put(new Food("ka1", null, 100, "Food"), 5);
//    
//    t1.put("1", f1);
//    t1.put("2", f2);
//    
//    Controller.roomMenu = t1;
//    Controller.saveFile();
//    }
    @Override
    public void run() {
        Thread outToClientThread = new Thread(() -> {
            OutToClient();
        });
        outToClientThread.start();

        Thread inFromClientThread = new Thread(() -> {
            InFromClient();
        });
        inFromClientThread.start();
    }

}
