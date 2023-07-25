package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StraightTest {

    @DisplayName("두 좌표를 받으면, 직선을 생성한다.")
    @Test
    void calculateDistance() {
        Point from = Point.of(10, 10);
        Point into = Point.of(14, 15);

        Straight result = Straight.of(from, into);

        assertThat(result.measure()).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("주어진 좌표는 존재하는 좌표여야 한다.")
    @Test
    void checkPoints() {
        Point from = Point.of(10, 10);
        Point into = Point.of(14, 15);

        assertThatThrownBy(() -> Straight.of(from, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");

        assertThatThrownBy(() -> Straight.of(null, into))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");
    }
}
