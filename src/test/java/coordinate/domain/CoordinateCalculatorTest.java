package coordinate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateCalculatorTest {

    @DisplayName("두 좌표를 받으면, 직선을 생성한다.")
    @Test
    void calculateDistance() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        Point from = Point.of(10, 10);
        Point into = Point.of(14, 15);

        Straight result = coordinatecalculator.makeStraight(from, into);

        assertThat(result.calculateLength()).isEqualTo(6.403124, offset(0.00000099));
    }

    @DisplayName("주어진 좌표는 존재하는 좌표여야 한다.")
    @Test
    void checkPoints() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        Point from = Point.of(10, 10);
        Point into = Point.of(14, 15);

        assertThatThrownBy(() -> coordinatecalculator.makeStraight(from, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");

        assertThatThrownBy(() -> coordinatecalculator.makeStraight(null, into))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하는 좌표값을 입력해주세요.");
    }

    @DisplayName("좌표의 목록을 받으면 사각형을 생성한다.")
    @Test
    void makeSquare() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(22, 10));
        points.add(Point.of(22, 18));
        points.add(Point.of(10, 18));

        Square result = coordinatecalculator.makeSquare(points);

        assertThat(result.getArea()).isEqualTo(96.0, offset(0.99));
    }

    @DisplayName("사각형을 만들기 위해서는 4개의 좌표가 필요하다.")
    @Test
    void checkPointsForMakeSquare() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        List<Point> points = new ArrayList<>();
        points.add(Point.of(10, 10));
        points.add(Point.of(22, 10));
        points.add(Point.of(22, 18));

        assertThatThrownBy(() -> coordinatecalculator.makeSquare(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형을 만들려면 정확히 4개의 좌표가 필요합니다.");

        points.add(Point.of(1, 2));
        points.add(Point.of(3, 13));
        assertThatThrownBy(() -> coordinatecalculator.makeSquare(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형을 만들려면 정확히 4개의 좌표가 필요합니다.");
    }

    @DisplayName("찌그러진 사각형은 허용하지 않는다.")
    @Test
    void checkSquare() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 4));
        points.add(Point.of(10, 3));
        points.add(Point.of(6, 1));
        points.add(Point.of(11, 1));

        assertThatThrownBy(() -> coordinatecalculator.makeSquare(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("사다리꼴은 허용되지 않는다.")
    @Test
    void checkTrapezoid() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 4));
        points.add(Point.of(11, 4));
        points.add(Point.of(6, 1));
        points.add(Point.of(11, 1));

        assertThatThrownBy(() -> coordinatecalculator.makeSquare(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("등변 사다리꼴은 허용되지 않는다.")
    @Test
    void checkIsoscelesTrapezoid() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 4));
        points.add(Point.of(10, 4));
        points.add(Point.of(6, 1));
        points.add(Point.of(12, 1));

        assertThatThrownBy(() -> coordinatecalculator.makeSquare(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }

    @DisplayName("마름모는 허용되지 않는다.")
    @Test
    void checkDiamond() {
        CoordinateCalculator coordinatecalculator = new CoordinateCalculator();
        List<Point> points = new ArrayList<>();
        points.add(Point.of(8, 3));
        points.add(Point.of(4, 2));
        points.add(Point.of(8, 1));
        points.add(Point.of(12, 2));

        assertThatThrownBy(() -> coordinatecalculator.makeSquare(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형은 사다리꼴, 마름모를 제외한 직사각형만 허용합니다.");
    }
}
