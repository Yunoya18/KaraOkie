package karaokie.Menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class roomMenu extends Menus {

    private String roomNumber;
    protected Map<Food, Integer> map ;
    protected Map<String, Map<Food, Integer>> map2;
    
    public roomMenu(){
        
        map2 = new HashMap<>();
        
        File file = new File("ro.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("ro.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
       
        }
        else{
            map.put(new Food("",null,0.0,""), 0);
        }
    }

     public void addMenu(Food food, int i) {
         map = new HashMap<>();
         File file = new File("ro.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("ro.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
       
        }
        else{
            map.put(new Food("",null,0.0,""), 0);
        }
    
        map.put(food, i);
        this.saveMap();
        System.out.println("save");

    }
//
//    @Override
//    public void removeMenu(Food food) {
//        if(map.get(food.getName()) == 1){
//            map.remove(food.getName());
//        }
//        else if(map.get(food.getName())>1){
//            int i = map.get(food.getName());
//            map.put(food.getName(), i - 1);
//        }
//    }

    public void tranMap(String nameroom) {
        this.loadMap();
        map2.put(nameroom, map);
        
        try (Socket clientSocket = new Socket("26.26.134.224", 1234); ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
            objectOutputStream.writeObject(map2);
            System.out.println(map2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void saveMap() {
        try (FileOutputStream fout = new FileOutputStream("ro.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            oout.writeObject(map);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    @Override
    public void loadMap(){
         map = new HashMap<>();
        File file = new File("cardusertran.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("cardusertran.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
       
        }
        else{
            map.put(new Food("",null,0.0,""), 0);
        }
    }

    public void setMap(Map<Food, Integer> map) {
        this.map = map;
    }

    public Map<Food, Integer> getMap() {
        return map;
    }
    
    public void setroomNumber(String s){
        roomNumber = s;
    }
    
    public String getroomNumber(){
        return roomNumber;
    }
}
