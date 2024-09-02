package Generics.Bounded;

class BankAccount<T extends Number>{
    public void display(T[] numbers){
        for(T n:numbers){
            System.out.print(n + " ");
        }
    }
}

class Friends<T extends Number & Runnable>{

    public void display(T[] numbers){
        for(T num : numbers){
            System.out.println(num.intValue() + " is int value ..");
            num.run();
            System.out.println("value : " + num.floatValue());
        }
    }

}

class Friend extends Number implements Runnable{

    private final double value;

    Friend(double value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("running the  master : " + value);
    }

    @Override
    public int intValue() {
        return (int) this.value;
    }

    @Override
    public long longValue() {
        return (long) this.value;
    }

    @Override
    public float floatValue() {
        return (float) this.value;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }
}


public class BE1 {
    public static void main(String[] args) {
        BankAccount<Integer> account = new BankAccount<>();
        BankAccount<Double> secondAccount = new BankAccount<>();
        Integer[] a = {1,2,3,4};
        Double[] b= {1.2,2.3,3.4,4.5};

        account.display(a);
        secondAccount.display(b);

        Friend f1 = new Friend(1.0);
        Friend f2 = new Friend(2.0);
        Friend f3 = new Friend(3.0);
        Friend f4 = new Friend(4.0);
        Friend f5 = new Friend(5.0);

        Friend[] fris = {f1,f2,f3,f4,f5};

        Friends<Friend> fr = new Friends<>();
        fr.display(fris);


    }



}
