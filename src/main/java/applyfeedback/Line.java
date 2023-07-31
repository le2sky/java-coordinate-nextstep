package applyfeedback;

import java.util.List;
import java.util.Objects;

public class Line {

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
            throw new IllegalArgumentException("유효한 좌표를 입력해주세요.");
        }
    }

    private static void checkHasNull(final List<Point> points) {
        if (hasNull(points)) {
            throw new IllegalArgumentException("유효한 좌표를 입력해주세요.");
        }
    }

    private static boolean hasNull(final List<Point> points) {
        return points.stream().anyMatch(Objects::isNull);
    }

    private static void checkPointsSize(final List<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException("직선의 좌표는 2개 입니다.");
        }
    }

    public double area() {
        return points.get(0).calculateDistanceWith(points.get(1));
    }
}
