package LambdaStream.groupingBy;

import LambdaStream.groupingBy.Utility.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingPartTwo {
    public static void main(String[] args) {

        List<Student> studentList =
                Arrays.asList(
                        new Student(121,"santosh",89,55000),
                        new Student(122,"suresh",89,65000),
                        new Student(123,"ankesh",90,55000),
                        new Student(124,"sujit",89,65000),
                        new Student(125,"sumit",90,55000),
                        new Student(126,"akashh",89,65000),
                        new Student(127,"sakshi",89,55000),
                        new Student(128,"komal",91,65000),
                        new Student(129,"suresh",89,75000),
                        new Student(130,"mahesh",91,75000),
                        new Student(131,"diksha",89,85000),
                        new Student(132,"yagini",91,55000)


                );


        Map<Integer,Student> collectors = studentList.stream().collect(Collectors.toMap(e->e.getParentSalary(), e->e,(existing,replacement)->replacement));

        System.out.println("*8");
        collectors.entrySet().stream().forEach(e-> System.out.println(e.getKey()+ " : " + e.getValue()));


        Map<Integer,Map<Integer,Long>> lister = studentList.stream().collect(Collectors.groupingBy(e->e.getParentSalary(),
                Collectors.groupingBy(e->e.getMarks(),Collectors.counting())));

        lister.entrySet().stream().forEach((e)->{
            System.out.println("*********** " + e.getKey() + " ***************");
            e.getValue().entrySet().stream().forEach((k)->{
                System.out.println("**** " + k.getKey() + " : " + k.getValue());
            });
        });

        System.out.println("*********************************");

        Map<String,Integer> studentDetails = studentList.stream().collect(Collectors.toMap(e->e.getName(),e->e.getMarks(),(exis,rep)->exis));
        studentDetails.forEach((e,v)-> System.out.println(e + " " + v));

        System.out.println("***********************************");


        String names = studentList.stream().map(e->e.getName()).collect(Collectors.joining(":"));

        System.out.println(names);

        System.out.println("*****************************");
    }
}
