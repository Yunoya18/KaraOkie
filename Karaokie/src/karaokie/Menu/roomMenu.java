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
    protected Map<String, Integer> map ;
    protected Map<String, Map<String, Integer>> map2;

    public void addMenu(String name, int i) {
        map.put(name, i);

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

    public void tranMap() {

        try (Socket clientSocket = new Socket("26.26.134.224", 6789); ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
            objectOutputStream.writeObject(map);
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void saveMap() {
        try (FileOutputStream fout = new FileOutputStream("roommenu.dat"); ObjectOutputStream oout = new ObjectOutputStream(fout);) {

            oout.writeObject(map);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    @Override
    public void loadMap(){
         map = new HashMap<>();
        File file = new File("roommenu.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("roommenu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        

        }
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }
    
    public void setroomNumber(String s){
        roomNumber = s;
    }
    
    public String getroomNumber(){
        return roomNumber;
    }
}
