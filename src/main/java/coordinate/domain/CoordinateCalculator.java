package coordinate.domain;

import java.util.List;

public class CoordinateCalculator {

    public double calculateDistance(final List<Coordinate> coordinates) {
        checkCoordinatesLength(coordinates);

        Coordinate from = coordinates.get(0);
        Coordinate into = coordinates.get(1);

        return from.calculateDistanceWith(into);
    }

    private void checkCoordinatesLength(final List<Coordinate> coordinates) {
        if (coordinates.size() != 2) {
            throw new IllegalArgumentException("직선의 길이를 계산하려면 정확히 2 개의 좌표가 필요합니다.");
        }
    }
}
