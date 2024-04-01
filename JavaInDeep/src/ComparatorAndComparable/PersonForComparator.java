package ComparatorAndComparable;

public class PersonForComparator implements Comparable<PersonForComparator> {
    private String name;
    private int age;

    public PersonForComparator(String name, int age) {
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

    @Override
    public int compareTo(PersonForComparator o) {
        return Integer.compare(this.age, o.getAge());
    }
}
