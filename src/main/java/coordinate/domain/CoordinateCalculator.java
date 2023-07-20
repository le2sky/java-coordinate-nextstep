package coordinate.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CoordinateCalculator {

    private static final int SQUARE_VERTEX = 4;
    private static final String SQUARE_SHAPE_EXCEPTION_MESSAGE = "사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.";

    public Straight makeStraight(final Point from, final Point into) {
        return Straight.of(from, into);
    }

    public Square makeSquare(final List<Point> points) {
        checkPointsLengthForSquare(points);

        return Square.from(calculateSquareArea(points));
    }

    private void checkPointsLengthForSquare(final List<Point> points) {
        if (points.size() != SQUARE_VERTEX) {
            throw new IllegalArgumentException("사각형을 만들려면 정확히 4개의 좌표가 필요합니다.");
        }
    }

    private double calculateSquareArea(final List<Point> points) {
        checkHasSameSide(points);

        Point cornerCoordinates = findCorner(points);
        double width = calculateWidth(points, cornerCoordinates);
        double height = calculateHeight(points, cornerCoordinates);

        return width * height;
    }

    private void checkHasSameSide(final List<Point> points) {
        Point widthFrom = points.get(0);
        Point widthInto = points.stream()
                .filter(point -> isInSameVerticalSide(widthFrom, point))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(SQUARE_SHAPE_EXCEPTION_MESSAGE));
        double standardSide = widthFrom.calculateDistanceWith(widthInto);

        List<Point> target = points.stream()
                .filter(point -> !point.equals(widthFrom) && !point.equals(widthInto))
                .collect(Collectors.toList());
        double targetSide = target.get(0).calculateDistanceWith(target.get(1));

        if (standardSide != targetSide) {
            throw new IllegalArgumentException(SQUARE_SHAPE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isInSameVerticalSide(final Point target, final Point point) {
        return !point.equals(target) && point.getY() == point.getY();
    }

    private Point findCorner(final List<Point> points) {
        return points.stream().filter(p -> isCorner(points, p))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(SQUARE_SHAPE_EXCEPTION_MESSAGE));
    }

    private boolean isCorner(final List<Point> points, final Point point) {
        long count = points.stream()
                .filter(target -> !target.equals(point) && (target.getX() == point.getX()
                        || target.getY() == point.getY()))
                .count();

        return count == 2;
    }

    private double calculateWidth(final List<Point> points, final Point corner) {
        Point widthInto = points.stream()
                .filter(coordinate -> isInSameHorizontalSide(corner, coordinate))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return corner.calculateDistanceWith(widthInto);
    }

    private boolean isInSameHorizontalSide(final Point target, final Point point) {
        return !point.equals(target) && point.getX() == target.getX();
    }

    private double calculateHeight(final List<Point> points, final Point corner) {
        Point heightInto = points.stream()
                .filter(coordinate -> isInSameVerticalSide(corner, coordinate))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return corner.calculateDistanceWith(heightInto);
    }
}
