package DesignPattern.adapterDesignPattern.SecondProgram;

public class LegacyShapeImpl implements LegacyShape{

    @Override
    public void draw() {
        System.out.println("legacy shape drawn ");
    }
}
