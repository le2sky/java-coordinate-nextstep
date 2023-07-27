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

        OutputView.writeMeasurement(figureFactory.create(points));
    }
}
