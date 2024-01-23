package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    private Point midPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return new Point((Math.abs(endPoint.getX()) - Math.abs(beginPoint.getX())) / 2, (Math.abs(endPoint.getY()) - Math.abs(beginPoint.getY()))/ 2);
    }
}
// END
