package coordinate.view;

import coordinate.domain.Straight;

public class OutputView {

    private static final String WRITE_STRAIGHT_LENGTH_MESSAGE = "두 점 사이 거리는 %.6f";

    public static void writeStraightLength(final Straight straight) {
        System.out.println(String.format(WRITE_STRAIGHT_LENGTH_MESSAGE, straight.getLength()));
    }
}
