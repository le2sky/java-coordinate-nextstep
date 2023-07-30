package applyfeedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("Point 생성 테스트")
    @Test
    void point() {
        Point point = Point.of(1, 2);
        Point otherPoint = Point.of(1, 2);

        assertThat(point).isEqualTo(otherPoint);
    }

    @DisplayName("X, Y좌표 모두 최대 24까지만 입력할 수 있다.")
    @Test
    void checkXYMaxSize() {
        assertThatThrownBy(() -> Point.of(1, 25))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 1부터 24까지만 입력할 수 있습니다.");

        assertThatThrownBy(() -> Point.of(25, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 1부터 24까지만 입력할 수 있습니다.");
    }

    @DisplayName("X, Y좌표 모두 최소 1까지만 입력할 수 있다.")
    @Test
    void checkXYMinSize() {
        assertThatThrownBy(() -> Point.of(0, 24))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 1부터 24까지만 입력할 수 있습니다.");

        assertThatThrownBy(() -> Point.of(24, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y좌표 모두 1부터 24까지만 입력할 수 있습니다.");
    }

    @DisplayName("다른 Point와 거리를 계산한다.")
    @Test
    void calculateDistanceWith() {
        Point point = Point.of(10, 10);
        Point other = Point.of(14, 15);

        double result = point.calculateDistanceWith(other);

        assertThat(result).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("알 수 없는 Point와 거리를 계산할 수 없다.")
    @Test
    void calculateDistanceWithNull() {
        Point point = Point.of(10, 10);

        assertThatThrownBy(() -> point.calculateDistanceWith(null))
                .isInstanceOf(NullPointerException.class);
    }
}
