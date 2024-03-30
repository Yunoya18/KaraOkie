import java.util.HashMap;
import java.util.Map;

public class ShowOrder2 {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("apple", 50);

        // Iterate over the keys using a for-each loop
        for (String key : map.keySet()) {
            System.out.println("Key: " + map.get(key));
        }
    }
}