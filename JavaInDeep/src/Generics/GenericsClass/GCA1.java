package Generics.GenericsClass;

public class GCA1 {
    public static void main(String[] args) {

        Box<String> one = new Box();
        one.setValue("ajit");
        one.getName(1);
        one.getName("ajit");

        System.out.println(one.getValue());

    }
}

class Box<T>{
    private T value;

    public void setValue(T value){
        this.value=value;
    }

    public T getValue(){
        return this.value;
    }

    public<U> U getName(U name){
        return name;
    }
}