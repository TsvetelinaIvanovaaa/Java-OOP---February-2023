package SOLID_Lab.OpenClosedPrinciple.DrawingShape;

import SOLID_Lab.OpenClosedPrinciple.DrawingShape.interfaces.DrawingManager;
import SOLID_Lab.OpenClosedPrinciple.DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {


    @Override
    public void draw(Shape shape) {
        if (shape instanceof Circle)
        {
            this.drawCircle((Circle)shape);
        }
        else if (shape instanceof Rectangle)
        {
            this.drawRectangle(((Rectangle)shape));
        }
    }
    public void drawCircle(Circle circle)
    {
        System.out.println("Circle");
    }

    public void drawRectangle(Rectangle rectangle)
    {
        System.out.println("Rectangle");
    }
}
