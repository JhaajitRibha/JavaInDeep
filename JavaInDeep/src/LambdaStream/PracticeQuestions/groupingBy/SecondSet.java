package LambdaStream.PracticeQuestions.groupingBy;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondSet {
    public static void main(String[] args) {
       List<Person> personList =  Arrays.asList(
               new Person("akansh",56),
               new Person("surbhi",78),
               new Person("sameer",56),
               new Person("surendra",78),
               new Person("akhilesh",25),
               new Person("vikash",25),
               new Person("ankitaa",56),
               new Person("amar",78));

      Map<Integer,List<Person>> grouped = personList.stream()
               .collect(Collectors.groupingBy(Person::getAge));

      grouped.entrySet().stream().forEach(e-> System.out.println(e.getKey() + " : " + e.getValue()));
      grouped.keySet().forEach(System.out::println);


        System.out.println("************************************");

        Map<Integer,Map<Integer,List<Person>>> nestingGrouping
                =personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.groupingBy(e->e.getName().length())

                ));

       nestingGrouping
               .entrySet()
               .stream()
               .forEach(e->
               {
                   System.out.println("age : " + e.getKey());
                  e.getValue().entrySet().stream().forEach(
                          f-> System.out.println(f.getKey()+ " : " + f.getValue())
                  );

                   System.out.println("****");
               });
        System.out.println("**********************************");

    }

}
