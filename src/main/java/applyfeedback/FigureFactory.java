package applyfeedback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();
    private static final int SIZE_OF_LINE = 2;
    private static final int SIZE_OF_TRIANGLE = 3;
    private static final int SIZE_OF_RECTANGLE = 4;

    static {
        classifier.put(SIZE_OF_LINE, Line::from);
        classifier.put(SIZE_OF_TRIANGLE, Triangle::from);
        classifier.put(SIZE_OF_RECTANGLE, Rectangle::from);
    }

    public static Figure getInstance(final List<Point> points) {
        return classifier.get(points.size()).apply(points);
    }
}
