package coordinate;

import coordinate.domain.CoordinateCalculator;
import coordinate.domain.Point;
import coordinate.view.InputView;
import coordinate.view.OutputView;
import java.util.List;

public class Application {

    public static void main(final String[] args) {
        List<Point> points = InputView.readPoints();

        CoordinateCalculator coordinateCalculator = new CoordinateCalculator();

        OutputView.writeGraph(points);

        if (points.size() == 2) {
            OutputView.writeStraightLength(coordinateCalculator.makeStraight(points.get(0),
                    points.get(1)));
        } else if (points.size() == 4) {
            OutputView.writeSquareArea(coordinateCalculator.makeSquare(points));
        }
    }
}
