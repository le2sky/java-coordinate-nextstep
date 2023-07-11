package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateTest {

    @DisplayName("X, Y 좌표 모두 최대 24까지만 입력할 수 있다.")
    @Test
    void checkRange() {
        assertThatThrownBy(() -> Coordinate.of(25, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 최대 24까지만 입력할 수 있습니다.");

        assertThatThrownBy(() -> Coordinate.of(10, 25))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 최대 24까지만 입력할 수 있습니다.");

        assertThatThrownBy(() -> Coordinate.of(25, 25))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 최대 24까지만 입력할 수 있습니다.");
    }

    @DisplayName("X, Y 좌표 모두 음수가 될 수 없다.")
    @Test
    void checkNegative() {
        assertThatThrownBy(() -> Coordinate.of(0, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 음수가 될 수 없습니다.");

        assertThatThrownBy(() -> Coordinate.of(-1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 음수가 될 수 없습니다.");

        assertThatThrownBy(() -> Coordinate.of(-1, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 음수가 될 수 없습니다.");
    }

    @DisplayName("X, Y 좌표가 허용된 범위값으로 들어오면, 유효한 객체가 반환된다.")
    @Test
    void of() {
        Coordinate coordinate = Coordinate.of(0, 0);

        assertThat(coordinate).isNotNull();
        assertThat(coordinate).isEqualTo(Coordinate.of(0, 0));
    }

    @DisplayName("직선 길이를 계산한다.")
    @Test
    void calculateDistanceWith() {
        Coordinate coordinate = Coordinate.of(10, 10);
        Coordinate other = Coordinate.of(14, 15);

        double result = coordinate.calculateDistanceWith(other);

        assertThat(result).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("알 수 없는 값과는 거리를 계산할 수 없다.")
    @Test
    void calculateDistanceWithNull() {
        assertThatThrownBy(() -> Coordinate.of(10, 10).calculateDistanceWith(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 값과 거리를 계산할 수 없습니다.");
    }
}
