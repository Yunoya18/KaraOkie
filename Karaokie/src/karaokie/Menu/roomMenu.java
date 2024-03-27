package karaokie.Menu;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class roomMenu extends Menu{
    protected Map<String, Integer> map = new HashMap<>();
    Socket socket;
    
    
    public roomMenu(Socket socket){
        
        this.socket = socket;
    }
    
    
    public void addMenu(Food food, int i) {
         map.put(food.getName(), i);
         
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
    ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                objectOutputStream.writeObject(map);
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }
    
}
