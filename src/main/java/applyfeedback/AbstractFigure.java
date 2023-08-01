package applyfeedback;

import java.util.List;
import java.util.Objects;

abstract class AbstractFigure implements Figure {

    private static final String INVALID_POINT_MESSAGE = "유효한 좌표를 입력해주세요.";

    private final List<Point> points;

    public AbstractFigure(final List<Point> points) {
        checkPointsNull(points);
        checkHasNull(points);
        checkHasDuplicatedPoint(points);

        this.points = points;
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

    private static void checkHasDuplicatedPoint(final List<Point> points) {
        System.out.println(points.stream().distinct().count());
        if (points.stream().distinct().count() != points.size()) {
            throw new IllegalArgumentException(INVALID_POINT_MESSAGE);
        }
    }

    protected List<Point> getPoints() {
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
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
