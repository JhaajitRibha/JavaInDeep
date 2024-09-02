package Generics;

import java.util.ArrayList;

public class Extra {
    public static void main(String[] args) {
        ArrayList s = new ArrayList<>();
        s.add(1);
        s.add("ajiait");

        s.stream().forEach(e-> System.out.println(e));

        String var = (String) s.get(1);//we have to cast
    }
}
