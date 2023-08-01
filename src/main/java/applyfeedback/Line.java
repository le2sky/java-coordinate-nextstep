package applyfeedback;

import java.util.List;

class Line extends AbstractFigure {

    private static final int POINT_SIZE_OF_LINE = 2;
    private static final String INVALID_POINT_SIZE_MESSAGE =
            "직선의 좌표는 " + POINT_SIZE_OF_LINE + "개 입니다.";

    private Line(final List<Point> points) {
        super(points);
    }

    public static Line from(final List<Point> points) {
        Line line = new Line(points);
        checkPointsSize(points);

        return line;
    }

    private static void checkPointsSize(final List<Point> points) {
        if (points.size() != POINT_SIZE_OF_LINE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE_MESSAGE);
        }
    }

    @Override
    public double area() {
        return getPoints().get(0).calculateDistanceWith(getPoints().get(1));
    }
}
