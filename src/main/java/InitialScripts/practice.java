package InitialScripts;

import org.testng.annotations.Test;

import java.util.*;

public class practice {

    public static void main(String[] arg) {
        int[] arr = {2, 5, 7, 3, 7, 4, 8, 4, 7, 3};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void mapSorting() {
        // Create a LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Add elements to the LinkedHashMap
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Three", 3);
        linkedHashMap.put("Five", 5);
        linkedHashMap.put("Two", 2);
        linkedHashMap.put("Four", 4);

      
        // Print the original LinkedHashMap
        System.out.println("1.Original LinkedHashMap: " + linkedHashMap);

        // Sort the LinkedHashMap by keys
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(linkedHashMap.entrySet());
        Collections.sort(entryList, Map.Entry.comparingByKey());

        // Print the sorted entryList by keys
        System.out.println("2.Sorted entryList by Keys: " + entryList);

        // Create a new LinkedHashMap using the sorted list
        LinkedHashMap<String, Integer> sortedByKeyMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedByKeyMap.put(entry.getKey(), entry.getValue());
        }

        // Print the LinkedHashMap sorted by keys
        System.out.println("Sorted LinkedHashMap by Keys: " + sortedByKeyMap);

        // Sort the LinkedHashMap by values
        Collections.sort(entryList, Map.Entry.comparingByValue());

        // Print the sorted entryList by values
        System.out.println("Sorted entryList by Values: " + entryList);

        // Create a new LinkedHashMap using the sorted list
        LinkedHashMap<String, Integer> sortedByValueMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedByValueMap.put(entry.getKey(), entry.getValue());
        }

        // Print the LinkedHashMap sorted by values
        System.out.println("Sorted LinkedHashMap by Values: " + sortedByValueMap);
    }
}

