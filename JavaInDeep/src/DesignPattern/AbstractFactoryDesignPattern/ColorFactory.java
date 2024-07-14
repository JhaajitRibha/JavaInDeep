package DesignPattern.AbstractFactoryDesignPattern;

// Factory for creating colors
public class ColorFactory implements AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null; // ColorFactory doesn't handle Shape
    }

    @Override
    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}
