package exercise;

// BEGIN
class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return balconyArea + area;
    }
    @Override
    public int compareTo(Home another) {
        if (this.area > another.getArea()) {
            return 1;
        } else if (this.area < another.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea()
                + " метров на " + floor + " этаже";
    }
}
// END
