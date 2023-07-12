package coordinate;

import coordinate.domain.Coordinate;
import coordinate.domain.CoordinateCalculator;
import coordinate.domain.Straight;
import coordinate.view.InputView;
import coordinate.view.OutputView;
import java.util.List;

public class Application {

    public static void main(final String[] args) {
        List<Coordinate> coordinates = InputView.readCoordinate();

        CoordinateCalculator coordinateCalculator = new CoordinateCalculator();

        Straight straight = coordinateCalculator.makeStraight(coordinates.get(0),
                coordinates.get(1));

        OutputView.writeStraightLength(straight);
    }
}
