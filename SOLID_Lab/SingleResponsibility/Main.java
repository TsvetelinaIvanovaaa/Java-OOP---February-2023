package SOLID_Lab.SingleResponsibility;


public class Main {
    public static void main(String[] args) {

        Shape shape=new Rectangle(5,10);
        DrawingManager drawingManager=new DrawingManagerImpl(new ConsoleRenderer());
        drawingManager.draw(shape);
    }
}