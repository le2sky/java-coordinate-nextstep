package coordinate.domain;

import java.util.List;
import java.util.Optional;

public class CoordinateCalculator {

    public Straight makeStraight(final Coordinate from, final Coordinate into) {
        checkCoordinates(from, into);

        return Straight.of(from.calculateDistanceWith(into));
    }

    private void checkCoordinates(final Coordinate from, final Coordinate into) {
        if (from == null || into == null) {
            throw new IllegalArgumentException("존재하는 좌표값을 입력해주세요.");
        }
    }

    public Square makeSquare(final List<Coordinate> coordinates) {
        return Square.from(calculateSquareArea(coordinates));
    }

    private double calculateSquareArea(final List<Coordinate> coordinates) {
        Coordinate cornerCoordinates = findCorner(coordinates);
        double width = calculateWidth(coordinates, cornerCoordinates);
        double height = calculateHeight(coordinates, cornerCoordinates);

        return width * height;
    }

    private Coordinate findCorner(final List<Coordinate> coordinates) {
        Optional<Coordinate> corner = Optional.empty();
        for (Coordinate coordinate : coordinates) {
            if (isCorner(coordinates, coordinate)) {
                corner = Optional.of(coordinate);
            }
        }

        return corner.orElseThrow(IllegalArgumentException::new);
    }

    private boolean isCorner(final List<Coordinate> coordinates, final Coordinate coordinate) {
        long count = coordinates.stream()
                .filter(target -> !target.equals(coordinate) && (target.getX() == coordinate.getX()
                        || target.getY() == coordinate.getY()))
                .count();

        return count == 2;
    }

    private double calculateWidth(final List<Coordinate> coordinates,
            final Coordinate cornerCoordinates) {
        Coordinate widthInto = coordinates.stream()
                .filter(coordinate -> !coordinate.equals(cornerCoordinates)
                        && coordinate.getX() == cornerCoordinates.getX())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return cornerCoordinates.calculateDistanceWith(widthInto);
    }

    private double calculateHeight(final List<Coordinate> coordinates,
            final Coordinate cornerCoordinates) {
        Coordinate heightInto = coordinates.stream()
                .filter(coordinate -> !coordinate.equals(cornerCoordinates)
                        && coordinate.getY() == cornerCoordinates.getY())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return cornerCoordinates.calculateDistanceWith(heightInto);
    }
}
