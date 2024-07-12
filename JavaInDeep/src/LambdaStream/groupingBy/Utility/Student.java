package LambdaStream.groupingBy.Utility;

public class Student {
    private int rollNo;
    private String name;
    private int marks;
    private int ParentSalary;

    public Student(){

    }

    public Student(int rollNo, String name, int marks, int parentSalary) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        ParentSalary = parentSalary;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getParentSalary() {
        return ParentSalary;
    }

    public void setParentSalary(int parentSalary) {
        ParentSalary = parentSalary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", ParentSalary=" + ParentSalary +
                '}';
    }
}
