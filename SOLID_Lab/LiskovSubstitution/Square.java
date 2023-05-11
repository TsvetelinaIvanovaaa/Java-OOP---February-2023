package SOLID_Lab.LiskovSubstitution;

public class Square implements Shape {
    private double side;
    public Square(double side) {
        this.side=side;
    }


    @Override
    public double getArea() {
        return side*side;
    }
}
