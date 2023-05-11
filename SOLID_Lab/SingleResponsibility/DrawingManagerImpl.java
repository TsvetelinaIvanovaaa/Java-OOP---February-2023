package SOLID_Lab.SingleResponsibility;

public class DrawingManagerImpl implements DrawingManager {


    private final Renderer renderer;

    public DrawingManagerImpl(Renderer renderer) {
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        renderer.render(shape);
    }
}
