package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointsTest {

    @DisplayName("주어진 좌표 목록 자체는 널값이 될 수 없다.")
    @Test
    void checkNull() {
        assertThatThrownBy(() -> Points.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 좌표 목록을 입력해주세요.");
    }

    @DisplayName("주어진 좌표는 모두 존재하는 좌표여야 한다.")
    @Test
    void checkPointsNull() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 3));
        points.add(Point.of(4, 2));
        points.add(null);
        points.add(Point.of(12, 2));

        assertThatThrownBy(() -> Points.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");
    }
}
