package coordinate.domain;

public class Square {

    private final double area;

    private Square(double area) {
        this.area = area;
    }

    public static Square from(final double area) {
        return new Square(area);
    }

    public double getArea() {
        return area;
    }
}
