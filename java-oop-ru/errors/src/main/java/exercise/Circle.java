package exercise;

// BEGIN
class Circle  {
    Point point;
    int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (this.getRadius() < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
         double square = Math.PI * (this.radius * this.radius);
         return square;
    }
}
// END
