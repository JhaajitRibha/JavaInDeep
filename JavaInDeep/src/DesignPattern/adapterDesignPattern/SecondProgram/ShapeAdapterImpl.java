package DesignPattern.adapterDesignPattern.SecondProgram;

public class ShapeAdapterImpl implements ShapeAdapter{

    private LegacyShape legacyShape;

    ShapeAdapterImpl(LegacyShape legacyShape){
        this.legacyShape = legacyShape;
    }


    @Override
    public void draw() {
        System.out.println("drawing using adapter..");
        legacyShape.draw();

    }


}
