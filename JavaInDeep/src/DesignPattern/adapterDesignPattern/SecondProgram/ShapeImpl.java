package DesignPattern.adapterDesignPattern.SecondProgram;

public class ShapeImpl implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing shape - original");
    }
}
