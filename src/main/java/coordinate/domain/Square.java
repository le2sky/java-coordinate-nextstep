package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Square {

    private static final int SQUARE_VERTEX = 4;
    private static final String SQUARE_SHAPE_EXCEPTION_MESSAGE = "사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.";
    private static final int MIN_NEIGHBOR_VERTEX = 2;

    private final List<Point> points;

    private Square(List<Point> points) {
        checkPoints(points);

        this.points = points;
    }

    public static Square from(final List<Point> points) {
        return new Square(points);
    }

    private void checkPoints(final List<Point> points) {
        checkPointsNull(points);
        checkPointsLength(points);
        checkIncludeNull(points);
        checkHasSameSide(points);
        checkHasCorner(points);
    }

    private void checkPointsNull(final List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("유효한 좌표 목록을 입력해주세요.");
        }
    }

    private void checkPointsLength(final List<Point> points) {
        if (points.size() != SQUARE_VERTEX) {
            throw new IllegalArgumentException("사각형을 만들려면 정확히 4개의 좌표가 필요합니다.");
        }
    }

    private void checkIncludeNull(final List<Point> points) {
        boolean isIncluded = points.stream()
                .filter(Objects::nonNull)
                .count() != SQUARE_VERTEX;

        if (isIncluded) {
            throw new IllegalArgumentException("존재하는 좌표값을 입력해주세요.");
        }
    }

    private void checkHasSameSide(final List<Point> points) {
        List<Point> selectedPoints = findAnySameVerticalPair(points);
        Point selectedFrom = selectedPoints.get(0);
        Point selectedInto = selectedPoints.get(1);

        double targetSideDistance = selectedFrom.calculateDistanceWith(selectedInto);
        double oppositeSideDistance = calculateOppositeDistance(points, selectedPoints);

        if (targetSideDistance != oppositeSideDistance) {
            throw new IllegalArgumentException(SQUARE_SHAPE_EXCEPTION_MESSAGE);
        }
    }

    private List<Point> findAnySameVerticalPair(final List<Point> points) {
        List<Point> selected = new ArrayList<>();
        Point selectedFrom = points.get(0);
        Point selectedInto = points.stream()
                .filter(point -> isSameVerticalSide(selectedFrom, point))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(SQUARE_SHAPE_EXCEPTION_MESSAGE));

        selected.add(selectedFrom);
        selected.add(selectedInto);

        return selected;
    }

    private double calculateOppositeDistance(final List<Point> points, final List<Point> selected) {
        List<Point> oppositePoints = points.stream()
                .filter(point -> !selected.contains(point))
                .collect(Collectors.toList());

        Point oppositeFrom = oppositePoints.get(0);
        Point oppositeInto = oppositePoints.get(1);

        return oppositeFrom.calculateDistanceWith(oppositeInto);
    }

    private void checkHasCorner(final List<Point> points) {
        if (!findCorner(points).isPresent()) {
            throw new IllegalArgumentException(SQUARE_SHAPE_EXCEPTION_MESSAGE);
        }
    }

    public double calculateSquareArea() {
        Point corner = findCorner(points).orElseThrow(InternalError::new);
        double width = calculateWidth(points, corner);
        double height = calculateHeight(points, corner);

        return width * height;
    }

    private Optional<Point> findCorner(final List<Point> points) {
        return points.stream()
                .filter(point -> isCorner(points, point))
                .findFirst();
    }

    private boolean isCorner(final List<Point> points, final Point point) {
        long count = points.stream()
                .filter(other -> isNeighborPoint(point, other))
                .count();

        return count == MIN_NEIGHBOR_VERTEX;
    }

    private boolean isNeighborPoint(Point point, Point other) {
        return (isSameVerticalSide(point, other) ||
                isSameHorizontalSide(point, other));
    }

    private double calculateWidth(final List<Point> points, final Point corner) {
        Point widthInto = points.stream()
                .filter(point -> isSameHorizontalSide(corner, point))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return corner.calculateDistanceWith(widthInto);
    }

    private double calculateHeight(final List<Point> points, final Point corner) {
        Point heightInto = points.stream()
                .filter(point -> isSameVerticalSide(corner, point))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return corner.calculateDistanceWith(heightInto);
    }

    private boolean isSameHorizontalSide(final Point point, final Point other) {
        return !other.equals(point) && other.getX() == point.getX();
    }

    private boolean isSameVerticalSide(final Point point, final Point other) {
        return !other.equals(point) && other.getY() == point.getY();
    }
}
