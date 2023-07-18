package coordinate.view;

import coordinate.domain.Point;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Point> readPoints() {
        System.out.println("좌표를 입력하세요.");
        String input = readLine();

        List<Point> points;
        try {
            points = InputMapper.mapToPoints(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());

            return readPoints();
        }

        return points;
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
