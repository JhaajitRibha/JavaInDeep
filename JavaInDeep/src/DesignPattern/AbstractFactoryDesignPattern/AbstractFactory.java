package DesignPattern.AbstractFactoryDesignPattern;

public interface AbstractFactory {
    Shape getShape(String shapeType);
    Color getColor(String colorType);
}
