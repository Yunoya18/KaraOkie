import java.util.HashMap;
import java.util.Map;

public class ComboBOxExample {
        public static void main(String[] args) {
        // Create a sample Map<String, Map<Food, Integer>>
        Map<String, Map<Food, Integer>> map = new HashMap<>();

        // Add some sample data
        Food apple = new Food("Apple");
        Food banana = new Food("Banana");
        Food orange = new Food("Orange");

        Map<Food, Integer> innerMap1 = new HashMap<>();
        innerMap1.put(apple, 5);
        innerMap1.put(banana, 3);

        Map<Food, Integer> innerMap2 = new HashMap<>();
        innerMap2.put(orange, 7);

        map.put("Fruits", innerMap1);
        map.put("OtherFruits", innerMap2);

        // Increment all values by 2
        incrementValues(map);

        // Print updated values
        for (Map.Entry<String, Map<Food, Integer>> entry : map.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            Map<Food, Integer> innerMap = entry.getValue();
            for (Map.Entry<Food, Integer> innerEntry : innerMap.entrySet()) {
                System.out.println("  Food: " + innerEntry.getKey().getName() + ", Quantity: " + innerEntry.getValue());
            }
        }
    }

    public static void incrementValues(Map<String, Map<Food, Integer>> map) {
        for (Map<Food, Integer> innerMap : map.values()) {
            for (Map.Entry<Food, Integer> entry : innerMap.entrySet()) {
                int incrementedValue = entry.getValue() + 2;
                entry.setValue(incrementedValue);
            }
        }
    }
}

class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}