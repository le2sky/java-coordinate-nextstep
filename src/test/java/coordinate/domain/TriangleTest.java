package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleTest {

    @DisplayName("좌표의 목록을 받으면 삼각형을 생성한다.")
    @Test
    void makeTriangle() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(14, 15));
        points.add(Point.of(20, 8));

        Triangle result = Triangle.from(points);

        assertThat(result.measure()).isEqualTo(29.0, offset(0.99));
    }

    @DisplayName("삼각형을 만들기 위해서는 3개의 좌표가 필요하다.")
    @Test
    void checkPointsForMakeTriangle() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(22, 10));

        assertThatThrownBy(() -> Triangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 만들려면 정확히 3개의 좌표가 필요합니다.");

        points.add(Point.of(1, 2));
        points.add(Point.of(3, 13));
        assertThatThrownBy(() -> Triangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 만들려면 정확히 3개의 좌표가 필요합니다.");
    }
}
