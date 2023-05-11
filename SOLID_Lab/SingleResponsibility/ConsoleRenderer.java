package SOLID_Lab.SingleResponsibility;

public class ConsoleRenderer implements Renderer{

    @Override
    public void render( Shape shape) {
        System.out.printf("Draw shape %s with area %.2f",shape.getClass().getSimpleName(),shape.getArea());
    }
}