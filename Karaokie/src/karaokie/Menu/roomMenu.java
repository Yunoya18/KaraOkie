package karaokie.Menu;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class roomMenu extends Menu {

    protected Map<Food, Integer> map = new HashMap<>();

    public void addMenu(Food food, int i) {
        map.put(food, i);

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

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }
}
