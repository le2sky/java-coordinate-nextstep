package coordinate.domain;

import java.util.List;
import java.util.Objects;

class Points {

    private final List<Point> points;

    private Points(final List<Point> points) {
        checkPointsNull(points);
        checkIncludeNull(points);

        this.points = points;
    }

    public static Points from(final List<Point> points) {
        return new Points(points);
    }

    private void checkPointsNull(final List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("유효한 좌표 목록을 입력해주세요.");
        }
    }

    private void checkIncludeNull(final List<Point> points) {
        boolean isIncluded = points.stream()
                .filter(Objects::nonNull)
                .count() != points.size();

        if (isIncluded) {
            throw new IllegalArgumentException("존재하는 좌표값을 입력해주세요.");
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
