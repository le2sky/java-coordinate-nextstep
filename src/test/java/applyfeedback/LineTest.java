package applyfeedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("직선의 좌표는 두개이다. 두개가 아닌 경우, 예외를 발생함")
    @Test
    void checkPointsSizeOfLine() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(1, 4));

        assertThatThrownBy(() -> Line.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직선의 좌표는 2개 입니다.");

        points.add(Point.of(1, 8));
        points.add(Point.of(1, 6));

        assertThatThrownBy(() -> Line.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직선의 좌표는 2개 입니다.");
    }

    @DisplayName("직선의 길이를 계산한다.")
    @Test
    void area() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(14, 15));
        Line line = Line.from(points);

        double result = line.area();

        assertThat(result).isEqualTo(6.403124, offset(0.00000099));
    }
}
