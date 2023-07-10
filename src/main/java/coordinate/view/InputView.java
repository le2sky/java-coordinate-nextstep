package coordinate.view;

import coordinate.domain.Coordinate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Coordinate> readCoordinate() {
        System.out.println("좌표를 입력하세요.");
        String input = readLine();

        List<Coordinate> coordinates = new ArrayList<>();
        try {
            coordinates = InputMapper.mapToCoordinates(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());

            readCoordinate();
        }

        return coordinates;
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
