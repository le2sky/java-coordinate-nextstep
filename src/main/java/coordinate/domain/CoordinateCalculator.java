package coordinate.domain;

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
}
