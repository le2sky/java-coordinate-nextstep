package applyfeedback;

import java.util.List;

class Rectangle extends AbstractFigure {

    private Rectangle(List<Point> points) {
        super(points);
    }

    public static Rectangle from(final List<Point> points) {
        return new Rectangle(points);
    }

    @Override
    public double area() {
        return 0;
    }
}
