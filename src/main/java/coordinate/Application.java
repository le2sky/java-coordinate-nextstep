package coordinate;

import coordinate.domain.Coordinate;
import coordinate.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Coordinate> coordinates = InputView.readCoordinate();

    }
}
