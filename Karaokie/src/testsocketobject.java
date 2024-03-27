
import karaokie.Menu.Food;
import karaokie.Menu.roomMenu;



public class testsocketobject {
    

    public static void main(String[] args) {
       roomMenu room = new roomMenu();
       Food  f = new Food();
       f.setName("nampra");
       f.setPrice(10.0);
       f.setImage(null);
       f.setType("water");
       room.addMenu(f, 5);
       room.tranMap();


       
    }
}
