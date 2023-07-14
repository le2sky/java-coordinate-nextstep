package coordinate.view;

import coordinate.domain.Coordinate;
import coordinate.domain.Straight;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String WRITE_STRAIGHT_LENGTH_MESSAGE = "두 점 사이 거리는 %.6f";

    public static void writeStraightLength(final Straight straight) {
        System.out.println(String.format(WRITE_STRAIGHT_LENGTH_MESSAGE, straight.getLength()));
    }

    public static void writeGraph(final List<Coordinate> coordinates) {
        ArrayList<ArrayList<String>> graph = new ArrayList<>();

        for (int i = 25; i > 1; i--) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 25; j > 0; j--) {
                if (j == 25) {
                    if ((i - 1) % 2 == 0) {
                        row.add(addLeftEmptyPadding(i - 1) + "|");
                    } else {
                        row.add("  |");
                    }
                } else {
                    row.add("   ");
                }
            }

            graph.add(row);

        }

        ArrayList<String> dividers = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            if (i == 0) {
                dividers.add("  +");
            } else {
                dividers.add("―――");
            }
        }

        graph.add(dividers);

        ArrayList<String> lastRow = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            if (i == 0) {
                lastRow.add(addLeftEmptyPadding(i) + " ");
            } else if (i % 2 == 0) {
                if (i >= 10) {
                    lastRow.add(" " + i);
                } else {
                    lastRow.add(" " + i + " ");
                }
            } else {
                lastRow.add("   ");
            }
        }

        graph.add(lastRow);

        for (Coordinate coordinate : coordinates) {
            graph.get(25 - coordinate.getX() - 1)
                    .set(coordinate.getY(), " ● ");
        }
        showGraph(graph);
    }

    private static void showGraph(ArrayList<ArrayList<String>> graph) {
        for (ArrayList<String> strings : graph) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static String addLeftEmptyPadding(int number) {
        if (number < 10) {
            return " " + number;
        }

        return String.valueOf(number);
    }
}
