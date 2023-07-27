package coordinate.domain;

import java.util.List;

class Straight implements Figure {

    private static final int STRAIGHT_COORDINATE_LENGTH = 2;
    private static final String STRAIGHT_MEASUREMENT_FORMAT = "두 점 사이 거리는 %f";

    private final Points points;

    private Straight(final Points points) {
        checkPointsLength(points.getPoints());

        this.points = points;
    }

    public static Straight from(final List<Point> points) {
        return new Straight(Points.from(points));
    }

    private void checkPointsLength(final List<Point> points) {
        if (points.size() != STRAIGHT_COORDINATE_LENGTH) {
            throw new IllegalArgumentException("직선을 만들려면 정확히 2개의 좌표가 필요합니다.");
        }
    }

    @Override
    public double measure() {
        List<Point> pointsList = points.getPoints();
        Point from = pointsList.get(0);
        Point into = pointsList.get(1);

        return from.calculateDistanceWith(into);
    }

    @Override
    public String getMeasurementResultFormat() {
        return STRAIGHT_MEASUREMENT_FORMAT;
    }
}
