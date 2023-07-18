package coordinate.domain;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Objects;

public class Point {

    private static final int MAX_RANGE = 24;
    private static final int MIN_RANGE = 0;

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        checkRange(x, y);
        checkNegative(x, y);

        this.x = x;
        this.y = y;
    }

    public static Point of(final int x, final int y) {
        return new Point(x, y);
    }

    private void checkRange(final int x, final int y) {
        if (x > MAX_RANGE || y > MAX_RANGE) {
            throw new IllegalArgumentException("X, Y좌표 모두 최대 24까지만 입력할 수 있습니다.");
        }
    }

    private void checkNegative(final int x, final int y) {
        if (x < MIN_RANGE || y < MIN_RANGE) {
            throw new IllegalArgumentException("X, Y좌표 모두 음수가 될 수 없습니다.");
        }
    }

    public double calculateDistanceWith(final Point other) {
        checkUnknownCoordinate(other);

        return sqrt(pow(x - other.x, 2) + pow(y - other.y, 2));
    }

    private static void checkUnknownCoordinate(final Point other) {
        if (other == null) {
            throw new IllegalArgumentException("알 수 없는 값과 거리를 계산할 수 없습니다.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point that = (Point) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
