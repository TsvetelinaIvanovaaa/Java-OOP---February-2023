package WorkingWithAbstraction.PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        //нова точка
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
