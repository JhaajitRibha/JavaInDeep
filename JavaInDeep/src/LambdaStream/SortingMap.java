package LambdaStream;

import java.util.*;
import java.util.stream.Collectors;

public class SortingMap {
    public static void main(String[] args) {

        Map<String,Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("John", 25);
        unsortedMap.put("Alice", 30);
        unsortedMap.put("Bob", 20);
        unsortedMap.put("Doe", 35);

        List<Map.Entry<String,Integer>> lists = new ArrayList<>(unsortedMap.entrySet());

        lists.forEach((e)-> System.out.println(e));

        lists.sort(Map.Entry.comparingByValue());

        lists.forEach((e)-> System.out.println(e));

        Map<String,Integer> sortedMap = new HashMap<>();
        for(Map.Entry<String,Integer> s:lists){
            sortedMap.put(s.getKey(),s.getValue());
        }


        System.out.println("****************");
        sortedMap.forEach((e,e2)-> System.out.println(e + " "  + e2));

        Map<String, Integer> sortedByValueMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,  // Key extractor
                        Map.Entry::getValue,  // Value extractor
                        (e1, e2) -> e1,  // Merge function, not needed here
                        LinkedHashMap::new  // Supplier to ensure insertion order is maintained
                ));




    }
}
