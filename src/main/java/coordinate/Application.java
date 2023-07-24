package coordinate;

import coordinate.domain.FigureFactory;
import coordinate.domain.Point;
import coordinate.view.InputView;
import coordinate.view.OutputView;
import java.util.List;

public class Application {

    public static void main(final String[] args) {
        List<Point> points = InputView.readPoints();

        FigureFactory figureFactory = new FigureFactory();

        OutputView.writeGraph(points);

        if (points.size() == 2) {
            OutputView.writeStraightLength(figureFactory.makeStraight(points.get(0),
                    points.get(1)));
        } else if (points.size() == 3) {
            OutputView.writeTriangleArea(figureFactory.makeTriangle(points));
        } else if (points.size() == 4) {
            OutputView.writeSquareArea(figureFactory.makeSquare(points));
        }
    }
}
