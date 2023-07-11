package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateCalculatorTest {

    @DisplayName("두 좌표를 받으면, 직선을 생성한다.")
    @Test
    void calculateDistance() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        Coordinate from = Coordinate.of(10, 10);
        Coordinate into = Coordinate.of(14, 15);

        Straight result = coordinatecalculator.makeStraight(from, into);

        assertThat(result.getLength()).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("주어진 좌표는 존재하는 좌표여야 한다.")
    @Test
    void checkCoordinates() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        Coordinate from = Coordinate.of(10, 10);
        Coordinate into = Coordinate.of(14, 15);

        assertThatThrownBy(() -> coordinatecalculator.makeStraight(from, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");

        assertThatThrownBy(() -> coordinatecalculator.makeStraight(null, into))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");
    }
}
