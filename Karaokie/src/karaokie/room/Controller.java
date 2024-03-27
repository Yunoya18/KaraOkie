
package karaokie.room;

import java.util.*;
import java.io.*;
import karaokie.Menu.*;
import java.net.*;

public class Controller{
    private static int Room_count;
    private static Map<Food, Integer> map;
    private static ArrayList<room> room = new ArrayList<>();
    private static ArrayList<roomMenu> roomMenu = new ArrayList<>();
    
    // Socket
    public static void InFromClient(){
        
        try(ServerSocket welcomeSocket = new ServerSocket(6789); 
            Socket connectionSocket = welcomeSocket.accept();
                
            ObjectInputStream oin = new ObjectInputStream(connectionSocket.getInputStream());
                
            ObjectOutputStream oout = new ObjectOutputStream(connectionSocket.getOutputStream());
            ){    

            //code do something
            map = (HashMap<Food, Integer>) oin.readObject();    
            System.out.println(map);
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public static void OutToClient(){
        
        try(ServerSocket welcomeSocket = new ServerSocket(6789); 
            Socket connectionSocket = welcomeSocket.accept();
            
            ObjectInputStream test = new ObjectInputStream(connectionSocket.getInputStream());    
                
            ObjectOutputStream oout = new ObjectOutputStream(connectionSocket.getOutputStream());
            ){    

            //code do something
            File menu = new File("menu.dat");
            if (menu.exists()){
                System.out.println("true");
                try (FileInputStream fin = new FileInputStream("menu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                    
                    
                    oout.writeObject((HashMap<String, ArrayList<Food>>) oin.readObject());
                } catch (IOException | ClassNotFoundException e) {

                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    
    
    public Controller(){
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
        if (file_roomMenu.exists()){
            try (FileInputStream fin = new FileInputStream("roomMenu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                roomMenu = (ArrayList<roomMenu>) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        } 
    }

    
    // Room Zone
    public static void addRoom(room r){
        room.set(Room_count, r);
        Room_count++;
    }
    
    public static void delRoom(int index){
        room.set(index, null);
    }
    
    public static room getRoom(int index){
        return room.get(index);
    }
    
    public static void CreateSmallRoom(){
        addRoom(new small_room(Room_count));
    }
    
    public static void CreateBigRoom(){
        addRoom(new big_room(Room_count));
    }
    
    // Menu Zone
    public static void setMenu(int index, roomMenu rm){
        roomMenu.set(index, rm);
    }
    
    public static roomMenu getMenu(int index){
        return roomMenu.get(index);
    }
    
    public static void delMenu(int index){
        setMenu(index, null);
    }
    
    // File Save
    public static void saveFile(){
        
        // room
        try (FileOutputStream fout = new FileOutputStream("room.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fout);){
            
            oout.writeObject(room);

        } catch (IOException e) {

            e.printStackTrace();
        }
        
        // roomMenu
        try (FileOutputStream fout = new FileOutputStream("roomMenu.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fout);){
            
            oout.writeObject(roomMenu);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
//        Controller.saveFile();
        Controller.OutToClient();
    }
}
