package LambdaStream.MethodRef;




public class MethodReference {
    public static void main(String[] args) {

        working work = Stuff::doWork;
        work.work();

        WorkingWithOnePerson workWithOnePerson = Stuff::workWithOnePerson;
        workWithOnePerson.doWork("ajit");


    }
}
