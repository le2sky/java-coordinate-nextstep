package applyfeedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Rectangle extends AbstractFigure {

    private static final int POINT_SIZE_OF_RECTANGLE = 4;
    private static final int SIZE_OF_UNIQUE_POINT_EACH_LINE = 2;
    private static final String INVALID_POINT_SIZE_MESSAGE =
            "사각형의 좌표는 " + POINT_SIZE_OF_RECTANGLE + "개 입니다.";
    private static final String INVALID_RECTANGLE_TYPE_MESSAGE =
            "사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.";

    private Rectangle(final List<Point> points) {
        super(points);
    }

    public static Rectangle from(final List<Point> points) {
        Rectangle rectangle = new Rectangle(points);
        checkPointsSize(points);
        checkRectangleType(points);

        return rectangle;
    }

    private static void checkPointsSize(final List<Point> points) {
        if (points.size() != POINT_SIZE_OF_RECTANGLE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE_MESSAGE);
        }
    }

    private static void checkRectangleType(final List<Point> points) {
        Set<Integer> uniqueXValues = convertToXUniqueValues(points);
        Set<Integer> uniqueYValues = convertToYUniqueValues(points);

        if (isNotUniqueCountForRectangleType(uniqueXValues.size())
                || isNotUniqueCountForRectangleType(uniqueYValues.size())) {
            throw new IllegalArgumentException(INVALID_RECTANGLE_TYPE_MESSAGE);
        }
    }

    private static Set<Integer> convertToXUniqueValues(final List<Point> points) {
        return convertToUniqueValues(points, Point::getX);
    }

    private static Set<Integer> convertToYUniqueValues(final List<Point> points) {
        return convertToUniqueValues(points, Point::getY);
    }

    private static Set<Integer> convertToUniqueValues(final List<Point> points,
            final Function<Point, Integer> convertFunction) {
        return points.stream().map(convertFunction)
                .collect(Collectors.toSet());
    }

    private static boolean isNotUniqueCountForRectangleType(final int size) {
        return size != SIZE_OF_UNIQUE_POINT_EACH_LINE;
    }

    @Override
    public double area() {
        List<Point> points = getPoints();
        double width = calculateDifference(convertToXUniqueValues(points));
        double height = calculateDifference(convertToYUniqueValues(points));

        return width * height;
    }

    private double calculateDifference(final Set<Integer> uniqueValues) {
        List<Integer> values = new ArrayList<>(uniqueValues);

        return Math.abs(values.get(0) - values.get(1));
    }
}
