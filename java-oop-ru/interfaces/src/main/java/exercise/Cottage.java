package exercise;

// BEGIN
class Cottage implements Home {

    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (this.getArea() < anotherArea) {
            return -1;
        } else if (this.getArea() > anotherArea) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
