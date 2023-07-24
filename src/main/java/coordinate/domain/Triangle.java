package coordinate.domain;

import java.util.List;
import java.util.Objects;

public class Triangle {

    private static final int TRIANGLE_VERTEX = 3;

    private final List<Point> points;

    private Triangle(final List<Point> points) {
        checkPointsNull(points);
        checkPointsLength(points);
        checkIncludeNull(points);

        this.points = points;
    }

    public static Triangle from(final List<Point> points) {
        return new Triangle(points);
    }

    private void checkPointsNull(final List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("유효한 좌표 목록을 입력해주세요.");
        }
    }

    private void checkPointsLength(final List<Point> points) {
        if (points.size() != TRIANGLE_VERTEX) {
            throw new IllegalArgumentException("삼각형을 만들려면 정확히 3개의 좌표가 필요합니다.");
        }
    }

    private void checkIncludeNull(final List<Point> points) {
        boolean isIncluded = points.stream()
                .filter(Objects::nonNull)
                .count() != TRIANGLE_VERTEX;

        if (isIncluded) {
            throw new IllegalArgumentException("존재하는 좌표값을 입력해주세요.");
        }
    }

    public double calculateTriangleArea() {
        double a = points.get(0).calculateDistanceWith(points.get(1));
        double b = points.get(1).calculateDistanceWith(points.get(2));
        double c = points.get(0).calculateDistanceWith(points.get(2));
        double s = (a + b + c) / 2;

        return Math.sqrt(((s * s) - (s * a)) * (s - b) * (s - c));
    }
}
