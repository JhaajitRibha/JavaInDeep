package ComparatorAndComparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Before sorting
        System.out.println("Before sorting by name:");
        for(Person p: people){
            System.out.println(p);
        }

        // Sorting by name
        Collections.sort(people, new NameComparator());

        // After sorting by name
        System.out.println("\nAfter sorting by name:");
        for(Person p: people){
            System.out.println(p);
        }

        // Before sorting by age
        System.out.println("\nBefore sorting by age:");
        for(Person p: people){
            System.out.println(p);
        }

        // Sorting by age
        Collections.sort(people, new AgeComparator());

        // After sorting by age
        System.out.println("\nAfter sorting by age:");
        for(Person p: people){
            System.out.println(p);
        }
    }
}

class Persons {
    private String name;
    private int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
