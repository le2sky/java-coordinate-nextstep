package coordinate.domain;

import java.util.List;

public class FigureFactory {

    public Figure create(final List<Point> points) {
        checkPointsNull(points);

        switch (points.size()) {
            case 2:
                return Straight.from(points);
            case 3:
                return Triangle.from(points);
            case 4:
                return Square.from(points);
            default:
                throw new IllegalArgumentException("해당 좌표 목록으로 만들 수 있는 도형은 존재하지 않습니다.");
        }
    }

    private void checkPointsNull(final List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("유효한 좌표 목록을 입력해주세요.");
        }
    }
}
