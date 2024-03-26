
package karaokie.room;

import java.util.*;
import karaokie.Menu.*;

public class Controller{
    private static int Room_count;
    private static ArrayList<roomMenu> roomMenu = new ArrayList<>();
    
    // Socket
    
    
    public static void setMenu(int index, roomMenu rm){
        roomMenu.set(index, rm);
    }
    
    public static roomMenu getMenu(int index){
        return roomMenu.get(index);
    }
    
    public static void delMenu(int index){
        setMenu(index, null);
    }
    
    public static void CreateSmallRoom(){
        new small_room(Room_count++);
    }
    
    public static void CreateBigRoom(){
        new big_room(Room_count++);
    }
}
