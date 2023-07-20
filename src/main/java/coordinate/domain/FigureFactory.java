package coordinate.domain;

import java.util.List;

public class FigureFactory {

    public Straight makeStraight(final Point from, final Point into) {
        return Straight.of(from, into);
    }

    public Square makeSquare(final List<Point> points) {
        return Square.from(points);
    }
}
