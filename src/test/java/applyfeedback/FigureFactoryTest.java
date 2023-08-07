package applyfeedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FigureFactoryTest {

    @DisplayName("좌표가 2개 주어지면 직선을 반환한다.")
    @Test
    public void line() {
        List<Point> points = Arrays.asList(
                Point.of(1, 2),
                Point.of(2, 3));

        Figure figure = FigureFactory.getInstance(points);
        assertThat(figure).isInstanceOfAny(Line.class);
    }

    @DisplayName("좌표가 3개 주어지면 삼각형을 반환한다.")
    @Test
    public void triangle() {
        List<Point> points = Arrays.asList(
                Point.of(1, 1),
                Point.of(4, 1),
                Point.of(1, 4));

        Figure figure = FigureFactory.getInstance(points);
        assertThat(figure).isInstanceOfAny(Triangle.class);
    }

    @DisplayName("좌표가 4개 주어지면 사각형을 반환한다.")
    @Test
    public void rectangle() {
        List<Point> points = Arrays.asList(
                Point.of(1, 1),
                Point.of(4, 1),
                Point.of(1, 4),
                Point.of(4, 4));

        Figure figure = FigureFactory.getInstance(points);
        assertThat(figure).isInstanceOfAny(Rectangle.class);
    }

    @DisplayName("정해진 도형 이외에는 반환할 수 없다. 정해진 도형은 직선, 삼각형, 사각형을 의미한다.")
    @Test
    void checkPointsLength() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));
        points.add(Point.of(1, 2));

        assertThatThrownBy(() -> FigureFactory.getInstance(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 좌표 목록으로 만들 수 있는 도형은 존재하지 않습니다.");
    }
}
