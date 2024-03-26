import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.NamedNodeMap;
public class Menu {
    protected Map<String, ArrayList<Food>> map;
    public Menu(){
        map = new HashMap<>();
        loadMap();

    }
    public Menu(Map map){
        this.map = map;
    }
    public void addMenu(Food food){
        map.get(food.getType()).add(food);
        saveMap();
        
    }
    public void removeMenu(Food food){
        for(int i = 0; i<= (map.get(food.getType()).size()) - 1; i++){
            if(map.get(food.getType()).get(i).getName().equals(food.getName())){
                map.get(food.getType()).remove(i);
                saveMap();
            }
        }
    }
    public void refeshMenu(){
        
    }
    public void saveMap(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("menu.dat"))) {
            oos.writeObject(map);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void loadMap(){
        File file = new File("menu.dat");
        if(file.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menu.dat"))) {
                Map map = (Map) ois.readObject();
                this.map = map;
            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
            }
        else{
            map.put("Appetizer", new ArrayList<Food>(null));
            map.put("Desert", new ArrayList<Food>(null));
            map.put("Beverage", new ArrayList<Food>(null));
            }
    }
}
