package ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ComparableExample {
    public static void main(String[] args) {
        List<PersonForComparator> people = new ArrayList<>();
        people.add(new PersonForComparator("Alice", 30));
        people.add(new PersonForComparator("Bob", 25));
        people.add(new PersonForComparator("Charlie", 35));

        // Before sorting
        System.out.println("Before sorting:");
        for (PersonForComparator p : people) {
            System.out.println(p);
        }

        // Sorting the list
       Collections.sort(people);

        // After sorting
        System.out.println("\nAfter sorting by age:");
        for (PersonForComparator p : people) {
            System.out.println(p);
        }
    }
}
