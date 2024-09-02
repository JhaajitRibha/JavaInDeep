package Generics.WildCards;

import java.util.List;

public class WE1 {
    public static void printList(List<?> list){
        for(Object li : list){
            System.out.println(li);
        }

    }
    public static void main(String[] args) {

        List<Integer> intList = List.of(1,2,3);
        List<String>  stringList = List.of("one","two","three");

        printList(intList);
        printList(stringList);

    }
}
