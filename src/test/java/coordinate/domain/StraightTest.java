package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StraightTest {

    @DisplayName("두 좌표를 받으면, 직선을 생성한다.")
    @Test
    void calculateDistance() {
        List<Point> points = new ArrayList<>();
        Point from = Point.of(10, 10);
        Point into = Point.of(14, 15);
        points.add(from);
        points.add(into);

        Straight result = Straight.from(points);

        assertThat(result.measure()).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("직선을 만들기 위해서는 2개의 좌표가 있어야 한다.")
    @Test
    void checkPointsForMakeStraight() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));

        assertThatThrownBy(() -> Straight.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직선을 만들려면 정확히 2개의 좌표가 필요합니다.");

        points.add(Point.of(10, 10));
        points.add(Point.of(10, 10));
        assertThatThrownBy(() -> Straight.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직선을 만들려면 정확히 2개의 좌표가 필요합니다.");
    }
}
