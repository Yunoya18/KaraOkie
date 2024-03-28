package karaokie.Menu;


import karaokie.Menu.Food;
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

public class Menus {

    public static Map<String, ArrayList<Food>> map;

    public Menus() {
        map = new HashMap<>();
        File file = new File("menu.dat");
        if (file.exists()) {
            try (FileInputStream fin = new FileInputStream("menu.dat"); ObjectInputStream oin = new ObjectInputStream(fin);) {
                map = (Map) oin.readObject();

            } catch (IOException | ClassNotFoundException e) {

                e.printStackTrace();
            }
        } else {
            map.put("Food", new ArrayList<Food>());
            map.put("Snack", new ArrayList<Food>());
            map.put("Drinks", new ArrayList<Food>());
        }

    }

    public Menus(HashMap<String, ArrayList<Food>> map) {
        this.map = map;
    }

    public void addMenu(Food food) {
        map.get(food.getType()).add(food);
        saveMap();
        
    }

    public void removeMenu(Food food) {
        for (int i = 0; i <= (map.get(food.getType()).size()) - 1; i++) {
            if (map.get(food.getType()).get(i).getName().equals(food.getName())) {
                map.get(food.getType()).remove(i);
                saveMap();
            }
        }
    }

    public void refeshMenu() {

    }

    public void saveMap() {
        try (FileOutputStream fout = new FileOutputStream("menu.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fout);){
            
            oout.writeObject(map);

        } catch (IOException e) {

            e.printStackTrace();
        }
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
//    public static void main(String[] args) {
//        Menus m = new Menus();
//        m.loadMap();
//        m.saveMap();
//    }
}
