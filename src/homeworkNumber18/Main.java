package homeworkNumber18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        callStream();
        System.out.println("\n" + "=".repeat(50) + "\n");
        System.out.println(callMap());
    }

    public static void callStream() {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 4, 1, 2, 3, 2, 7, 8, 6));
        System.out.println("list до операций");
        for(int element : list) System.out.print(element + "\t");
        System.out.println("\nСумма элементов до операций:");
        System.out.println(list.stream().reduce(Integer::sum).orElse(0));
        System.out.println("Сумма элементов в коллекции после удаления дубликатов, и фильтрации:");
        System.out.println(list.stream()
                .distinct()
                .filter(x -> x % 2 == 0)
                .reduce(Integer::sum).orElse(0));
    }

    public static List<String> callMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        map.put(4, "David");
        map.put(5, "Eva");
        map.put(6, "Frank");
        map.put(7, "Grace");
        map.put(8, "Henry");
        map.put(9, "Ivy");
        map.put(10, "Jack");
        map.put(11, "Kate");
        map.put(12, "Leo");
        map.put(13, "Mia");
        map.put(14, "Noah");
        map.put(15, "Olivia");

        return map.entrySet().stream().
                filter(entry -> entry.getKey() == 1 || entry.getKey() == 2
                        || entry.getKey() == 5 || entry.getKey() == 8 || entry.getKey() == 9
                        || entry.getKey() == 13).
                filter(entry -> entry.getValue().length() % 2 != 0).
                map(entry -> new StringBuilder(entry.getValue()).reverse().toString())
                .toList();
    }
}
