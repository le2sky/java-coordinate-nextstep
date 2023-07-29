package polymorphism;

import java.util.List;

public class FigureFactory {

    static Figure getInstance(List<Point> points) {
        if (points.size() == Line.LINE_POINT_SIZE) {
            return new Line(points);
        }

        if (points.size() == Triangle.TRIANGLE_POINT_SIZE) {
            return new Triangle(points);
        }

        if (points.size() == Rectangle.RECTANGLE_POINT_SIZE) {
            return new Rectangle(points);
        }

        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}
