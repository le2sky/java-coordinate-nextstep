package coordinate.view;

import coordinate.domain.Coordinate;
import coordinate.domain.Straight;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String WRITE_STRAIGHT_LENGTH_MESSAGE = "두 점 사이 거리는 %f";
    private static final String HORIZONTAL_DIVIDER_HEADER = "  +";
    private static final String HORIZONTAL_DIVIDER = "―――";
    private static final String VERTICAL_DIVIDER = "|";
    private static final String COORDINATE_SHAPE = " ● ";
    private static final String EMPTY_SPACE_SHAPE = "   ";
    private static final int MAX_COORDINATE_RANGE = 24;

    public static void writeStraightLength(final Straight straight) {
        System.out.println(String.format(WRITE_STRAIGHT_LENGTH_MESSAGE, straight.getLength()));
    }

    public static void writeGraph(final List<Coordinate> coordinates) {
        List<List<String>> graph = generateGraph();

        for (Coordinate coordinate : coordinates) {
            List<String> foundRow = graph.get(MAX_COORDINATE_RANGE - coordinate.getY());

            foundRow.set(coordinate.getX(), COORDINATE_SHAPE);
        }

        writeMarkedGraph(graph);
    }

    private static List<List<String>> generateGraph() {
        List<List<String>> graph = new ArrayList<>();

        for (int rowNo = MAX_COORDINATE_RANGE; rowNo > 0; rowNo--) {
            graph.add(generateRow(rowNo));
        }

        graph.add(generateHorizontalDivider());
        graph.add(generateHorizontalGraduation());

        return graph;
    }

    private static List<String> generateRow(final int rowNo) {
        List<String> row = new ArrayList<>();
        row.add(generateVerticalHeader(rowNo));

        for (int i = MAX_COORDINATE_RANGE; i > 0; i--) {
            row.add(EMPTY_SPACE_SHAPE);
        }

        return row;
    }

    private static String generateVerticalHeader(final int rowNo) {
        if (rowNo % 2 == 0) {
            return addLeftEmptyPadding(rowNo) + VERTICAL_DIVIDER;
        }

        return "  " + VERTICAL_DIVIDER;
    }

    private static String addLeftEmptyPadding(final int number) {
        if (number < 10) {
            return " " + number;
        }

        return String.valueOf(number);
    }

    private static List<String> generateHorizontalDivider() {
        List<String> dividers = new ArrayList<>();
        dividers.add(HORIZONTAL_DIVIDER_HEADER);

        for (int i = 0; i < MAX_COORDINATE_RANGE; i++) {
            dividers.add(HORIZONTAL_DIVIDER);
        }

        return dividers;
    }

    private static List<String> generateHorizontalGraduation() {
        List<String> horizontalGraduations = new ArrayList<>();
        horizontalGraduations.add(addLeftEmptyPadding(0) + " ");

        for (int colNo = 1; colNo < MAX_COORDINATE_RANGE + 1; colNo++) {
            horizontalGraduations.add(generateEachHorizontalGraduation(colNo));
        }

        return horizontalGraduations;
    }

    private static String generateEachHorizontalGraduation(final int colNo) {
        if (colNo % 2 == 0) {
            return addHorizontalGraduationPadding(colNo);
        }

        return EMPTY_SPACE_SHAPE;
    }

    private static String addHorizontalGraduationPadding(final int colNo) {
        if (colNo >= 10) {
            return " " + colNo;
        }

        return " " + colNo + " ";
    }

    private static void writeMarkedGraph(final List<List<String>> graph) {
        for (List<String> strings : graph) {
            for (String string : strings) {
                System.out.print(string);
            }

            System.out.println();
        }
    }
}
