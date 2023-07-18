package coordinate.domain;

import java.util.List;
import java.util.Optional;

public class CoordinateCalculator {

    public Straight makeStraight(final Point from, final Point into) {
        checkPoints(from, into);

        return Straight.from(from.calculateDistanceWith(into));
    }

    private void checkPoints(final Point from, final Point into) {
        if (from == null || into == null) {
            throw new IllegalArgumentException("존재하는 좌표값을 입력해주세요.");
        }
    }

    public Square makeSquare(final List<Point> points) {
        return Square.from(calculateSquareArea(points));
    }

    private double calculateSquareArea(final List<Point> points) {
        Point cornerCoordinates = findCorner(points);
        double width = calculateWidth(points, cornerCoordinates);
        double height = calculateHeight(points, cornerCoordinates);

        return width * height;
    }

    private Point findCorner(final List<Point> points) {
        Optional<Point> corner = Optional.empty();
        for (Point point : points) {
            if (isCorner(points, point)) {
                corner = Optional.of(point);
            }
        }

        return corner.orElseThrow(IllegalArgumentException::new);
    }

    private boolean isCorner(final List<Point> points, final Point point) {
        long count = points.stream()
                .filter(target -> !target.equals(point) && (target.getX() == point.getX()
                        || target.getY() == point.getY()))
                .count();

        return count == 2;
    }

    private double calculateWidth(final List<Point> points,
            final Point cornerCoordinates) {
        Point widthInto = points.stream()
                .filter(coordinate -> !coordinate.equals(cornerCoordinates)
                        && coordinate.getX() == cornerCoordinates.getX())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return cornerCoordinates.calculateDistanceWith(widthInto);
    }

    private double calculateHeight(final List<Point> points,
            final Point cornerCoordinates) {
        Point heightInto = points.stream()
                .filter(coordinate -> !coordinate.equals(cornerCoordinates)
                        && coordinate.getY() == cornerCoordinates.getY())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return cornerCoordinates.calculateDistanceWith(heightInto);
    }
}
