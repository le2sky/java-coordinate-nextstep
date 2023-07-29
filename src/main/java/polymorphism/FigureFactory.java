package polymorphism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final Map<Integer, Function<List<Point>, Figure>> classifier;

    static {
        classifier = new HashMap<>();
        classifier.put(Line.LINE_POINT_SIZE, Line::new);
        classifier.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::new);
        classifier.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::new);
    }

    static Figure getInstance(List<Point> points) {
        Function<List<Point>, Figure> figureConstructor = classifier.get(points.size());

        if (figureConstructor == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }

        return figureConstructor.apply(points);
    }
}
