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
    private static final String INVALID_POINT_SIZE_FOR_CLASSIFICATION =
            "해당 좌표 목록으로 만들 수 있는 도형은 존재하지 않습니다.";

    static {
        classifier.put(SIZE_OF_LINE, Line::from);
        classifier.put(SIZE_OF_TRIANGLE, Triangle::from);
        classifier.put(SIZE_OF_RECTANGLE, Rectangle::from);
    }

    public static Figure getInstance(final List<Point> points) {
        Function<List<Point>, Figure> figureStaticFactoryMethod = classifier.get(points.size());
        checkPointsSizeForClassification(figureStaticFactoryMethod);

        return figureStaticFactoryMethod.apply(points);
    }

    private static void checkPointsSizeForClassification(
            final Function<List<Point>, Figure> figureStaticFactoryMethod) {
        if (figureStaticFactoryMethod == null) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE_FOR_CLASSIFICATION);
        }
    }
}
