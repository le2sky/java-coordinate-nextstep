package applyfeedback;

import java.util.List;

class Triangle extends AbstractFigure {

    private static final int POINT_SIZE_OF_TRIANGLE = 3;
    private static final String INVALID_POINT_SIZE_MESSAGE =
            "삼각형의 좌표는 " + POINT_SIZE_OF_TRIANGLE + "개 입니다.";

    private Triangle(final List<Point> points) {
        super(points);
    }

    public static Triangle from(final List<Point> points) {
        Triangle triangle = new Triangle(points);
        checkPointsSize(points);

        return triangle;
    }

    private static void checkPointsSize(final List<Point> points) {
        if (points.size() != POINT_SIZE_OF_TRIANGLE) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE_MESSAGE);
        }
    }

    @Override
    public double area() {
        List<Point> points = getPoints();
        double a = points.get(0).calculateDistanceWith(points.get(1));
        double b = points.get(0).calculateDistanceWith(points.get(2));
        double c = points.get(1).calculateDistanceWith(points.get(2));
        double s = (a + b + c) / 2;

        return Math.sqrt(((s * s) - (s * a)) * (s - b) * (s - c));
    }
}
