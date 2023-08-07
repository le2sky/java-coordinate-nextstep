package applyfeedback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();

    static {
        classifier.put(2, Line::from);
        classifier.put(3, Triangle::from);
        classifier.put(4, Rectangle::from);
    }

    public static Figure getInstance(final List<Point> points) {
        return classifier.get(points.size()).apply(points);
    }
}
