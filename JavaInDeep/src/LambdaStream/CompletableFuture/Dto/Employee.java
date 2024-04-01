package LambdaStream.CompletableFuture.Dto;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String designation;
    private String department;
    private int salary;

    public Employee(int id, String name, int age, String gender, String designation, String department, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
