package applyfeedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @DisplayName("사각형의 좌표는 4개다.")
    @Test
    void checkPointsForMakeSquare() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(22, 10));
        points.add(Point.of(22, 18));

        assertThatThrownBy(() -> Rectangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형의 좌표는 4개 입니다.");

        points.add(Point.of(1, 2));
        points.add(Point.of(3, 13));
        assertThatThrownBy(() -> Rectangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형의 좌표는 4개 입니다.");
    }

    @DisplayName("찌그러진 사각형은 허용되지 않는다.")
    @Test
    void checkSquare() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 4));
        points.add(Point.of(10, 3));
        points.add(Point.of(6, 1));
        points.add(Point.of(11, 1));

        assertThatThrownBy(() -> Rectangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("사다리꼴은 허용되지 않는다.")
    @Test
    void checkTrapezoid() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 4));
        points.add(Point.of(11, 4));
        points.add(Point.of(6, 1));
        points.add(Point.of(11, 1));

        assertThatThrownBy(() -> Rectangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("등변 사다리꼴은 허용되지 않는다.")
    @Test
    void checkIsoscelesTrapezoid() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 4));
        points.add(Point.of(10, 4));
        points.add(Point.of(6, 1));
        points.add(Point.of(12, 1));

        assertThatThrownBy(() -> Rectangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("마름모는 허용되지 않는다.")
    @Test
    void checkDiamond() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 3));
        points.add(Point.of(4, 2));
        points.add(Point.of(8, 1));
        points.add(Point.of(12, 2));

        assertThatThrownBy(() -> Rectangle.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("사각형의 넓이를 계산한다.")
    @Test
    void area() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(22, 10));
        points.add(Point.of(22, 18));
        points.add(Point.of(10, 18));

        double result = Rectangle.from(points).area();

        assertThat(result).isEqualTo(96.0, offset(0.99));
    }
}
