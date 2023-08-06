package applyfeedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleTest {

    @DisplayName("삼각형의 좌표는 3개다")
    @Test
    void checkPointsForTriangle() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(22, 10));

        assertThatThrownBy(() -> Triangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형의 좌표는 3개 입니다.");

        points.add(Point.of(1, 2));
        points.add(Point.of(3, 13));
        assertThatThrownBy(() -> Triangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형의 좌표는 3개 입니다.");
    }

    @DisplayName("삼각형의 넓이를 계산한다.")
    @Test
    void area() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(14, 15));
        points.add(Point.of(20, 8));

        double result = Triangle.from(points).area();

        assertThat(result).isEqualTo(29.0, offset(0.99));
    }
}
