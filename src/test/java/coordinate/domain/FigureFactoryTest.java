package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FigureFactoryTest {

    @DisplayName("주어진 좌표 목록 자체는 널값이 될 수 없다.")
    @Test
    void checkNull() {
        FigureFactory figureFactory = new FigureFactory();

        assertThatThrownBy(() -> figureFactory.create(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 좌표 목록을 입력해주세요.");
    }

    @DisplayName("정해진 도형 이외에는 반환할 수 없다. 정해진 도형은 직선, 삼각형, 사각형을 의미한다.")
    @Test
    void checkPointsLength() {
        FigureFactory figureFactory = new FigureFactory();

        ArrayList<Point> points = new ArrayList<>();
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));

        assertThatThrownBy(() -> figureFactory.create(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 좌표 목록으로 만들 수 있는 도형은 존재하지 않습니다.");
    }
}
