package coordinate.domain;

import java.util.List;

class Triangle implements Figure {

    private static final int TRIANGLE_VERTEX = 3;

    private final Points points;

    private Triangle(final Points points) {
        checkPointsLength(points.getPoints());

        this.points = points;
    }

    public static Triangle from(final List<Point> points) {
        return new Triangle(Points.from(points));
    }

    private void checkPointsLength(final List<Point> points) {
        if (points.size() != TRIANGLE_VERTEX) {
            throw new IllegalArgumentException("삼각형을 만들려면 정확히 3개의 좌표가 필요합니다.");
        }
    }

    @Override
    public double measure() {
        List<Point> pointsList = points.getPoints();
        double a = pointsList.get(0).calculateDistanceWith(pointsList.get(1));
        double b = pointsList.get(1).calculateDistanceWith(pointsList.get(2));
        double c = pointsList.get(0).calculateDistanceWith(pointsList.get(2));
        double s = (a + b + c) / 2;

        return Math.sqrt(((s * s) - (s * a)) * (s - b) * (s - c));
    }
}
