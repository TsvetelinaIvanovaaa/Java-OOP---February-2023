package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    //true -> ако дадената точка е вътре в правоъгълника
    //false -> ако дадената точка не е вътре в правоъгълника
    public boolean contains(Point point){
        //1.да е вътре по х
        boolean isInsideX = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        //2. да е вътре по У
        boolean isInsideY = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
        return isInsideX && isInsideY;
    }
}
