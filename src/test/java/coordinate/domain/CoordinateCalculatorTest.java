package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateCalculatorTest {

    @DisplayName("두 좌표를 받으면, 직선의 길이를 반환한다.")
    @Test
    void calculateDistance() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        Coordinate from = Coordinate.of(10, 10);
        Coordinate into = Coordinate.of(14, 15);

        ArrayList<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(from);
        coordinates.add(into);

        double result = coordinatecalculator.calculateDistance(coordinates);

        assertThat(result).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("주어진 좌표의 수는 정확히 2개여야 한다.")
    @Test
    void checkCoordinatesLength() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        Coordinate from = Coordinate.of(10, 10);

        ArrayList<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(from);

        assertThatThrownBy(() -> coordinatecalculator.calculateDistance(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직선의 길이를 계산하려면 정확히 2 개의 좌표가 필요합니다.");
    }
}
