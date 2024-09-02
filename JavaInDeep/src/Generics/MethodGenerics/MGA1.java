package Generics.MethodGenerics;

public class MGA1 {

    public  <T> T print(T value){
        System.out.println(value);
        return value;
    }

    public  <U> void process(U process){
        System.out.println("processing :" + process);
    }

    public static void main(String[] args) {
        MGA1 s = new MGA1();
        String k = s.<String>print("1");
        int z = s.<Integer>print(1);
        System.out.println(k + " : " + z);
        s.process("samosa");
        s.process(2);
    }
}
