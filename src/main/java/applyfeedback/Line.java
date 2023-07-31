package applyfeedback;

import java.util.List;
import java.util.Objects;

class Line {

    private static final int POINT_SIZE_OF_LINE = 2;
    private static final String INVALID_POINT_MESSAGE = "유효한 좌표를 입력해주세요.";
    private static final String INVALID_POINT_SIZE_MESSAGE =
            "직선의 좌표는 " + POINT_SIZE_OF_LINE + "개 입니다.";

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = points;
    }

    public static Line from(final List<Point> points) {
        checkPointsNull(points);
        checkHasNull(points);
        checkPointsSize(points);

        return new Line(points);
    }

    private static void checkPointsNull(final List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException(INVALID_POINT_MESSAGE);
        }
    }

    private static void checkHasNull(final List<Point> points) {
        if (hasNull(points)) {
            throw new IllegalArgumentException(INVALID_POINT_MESSAGE);
        }
    }

    private static boolean hasNull(final List<Point> points) {
        return points.stream().anyMatch(Objects::isNull);
    }

    private static void checkPointsSize(final List<Point> points) {
        if (points.size() != POINT_SIZE_OF_LINE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE_MESSAGE);
        }
    }

    public double area() {
        return points.get(0).calculateDistanceWith(points.get(1));
    }
}
