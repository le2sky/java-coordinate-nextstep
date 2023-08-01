package applyfeedback;

import java.util.Objects;

class Point {

    private static final int MIN_POINT_RANGE = 1;
    private static final int MAX_POINT_RANGE = 24;
    private static final String OUT_RANGE_POINT_MESSAGE =
            "X, Y좌표 모두 " + MIN_POINT_RANGE + "부터 " + MAX_POINT_RANGE + "까지만 입력할 수 있습니다.";

    private final int x;
    private final int y;

    private Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(final int x, final int y) {
        if (isOutOfRange(x, y)) {
            throw new IllegalArgumentException(OUT_RANGE_POINT_MESSAGE);
        }

        return new Point(x, y);
    }

    private static boolean isOutOfRange(final int x, final int y) {
        return isOutOfMaxRange(x, y) || isOutOfMinRange(x, y);
    }

    private static boolean isOutOfMaxRange(final int x, final int y) {
        return x > MAX_POINT_RANGE || y > MAX_POINT_RANGE;
    }

    private static boolean isOutOfMinRange(final int x, final int y) {
        return x < MIN_POINT_RANGE || y < MIN_POINT_RANGE;
    }

    public double calculateDistanceWith(final Point other) {
        double a = Math.pow(this.x - other.x, 2);
        double b = Math.pow(this.y - other.y, 2);

        return Math.sqrt(a + b);
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
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
