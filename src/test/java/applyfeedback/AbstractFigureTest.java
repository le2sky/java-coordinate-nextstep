package applyfeedback;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractFigureTest {

    @DisplayName("좌표가 널값인 경우는 허용되지 않는다.")
    @Test
    void checkPointsNull() {
        assertThatThrownBy(() -> Line.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 좌표를 입력해주세요.");
    }

    @DisplayName("좌표 목록에 널이 포함되는 것은 허용되지 않는다.")
    @Test
    void hasNull() {
        List<Point> points = new ArrayList<>();
        points.add(null);
        points.add(Point.of(1, 2));

        assertThatThrownBy(() -> Line.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 좌표를 입력해주세요.");
    }

    @DisplayName("좌표 목록에 중복 좌표가 포함되어 있는 경우는 허용되지 않는다.")
    @Test
    void hasDuplicatedPoint() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));

        assertThatThrownBy(() -> Line.from(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 좌표를 입력해주세요.");
    }
}
