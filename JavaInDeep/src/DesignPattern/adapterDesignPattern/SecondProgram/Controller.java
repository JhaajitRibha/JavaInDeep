package DesignPattern.adapterDesignPattern.SecondProgram;

public class Controller {
    public static void main(String[] args) {

        ShapeAdapter s = new ShapeAdapterImpl(new LegacyShapeImpl());
        s.draw();
    }



}
