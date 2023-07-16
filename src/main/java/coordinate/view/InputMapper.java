package coordinate.view;

import coordinate.domain.Coordinate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputMapper {

    private static final Pattern COORDINATE_NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern COORDINATE_PATTERN = Pattern.compile("\\(\\d+,\\d+\\)");
    private static final String INVALID_COORDINATE_FORMAT_MESSAGE
            = "좌표의 형식은 (x,y) 입니다. 여러 좌표를 입력하시려면 - 를 구분자로 이용해주세요.";
    private static final String SPLIT_DELIMITER = "-";

    public static List<Coordinate> mapToCoordinates(final String input) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (String target : input.split(SPLIT_DELIMITER)) {
            checkCoordinateInputForm(target);

            coordinates.add(buildCoordinate(findNumbers(target)));
        }

        return coordinates;
    }

    private static void checkCoordinateInputForm(final String input) {
        Matcher matcher = COORDINATE_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_COORDINATE_FORMAT_MESSAGE);
        }
    }

    private static Coordinate buildCoordinate(final List<Integer> foundNumbers) {
        checkFoundNumberSize(foundNumbers);

        return Coordinate.of(foundNumbers.get(0), foundNumbers.get(1));
    }

    private static void checkFoundNumberSize(final List<Integer> foundNumbers) {
        if (foundNumbers.size() != 2) {
            throw new IllegalArgumentException(INVALID_COORDINATE_FORMAT_MESSAGE);
        }
    }

    private static List<Integer> findNumbers(final String target) {
        Matcher matcher = COORDINATE_NUMBER_PATTERN.matcher(target);
        List<Integer> foundNumbers = new ArrayList<>();

        while (matcher.find()) {
            foundNumbers.add(Integer.parseInt(matcher.group()));
        }

        return foundNumbers;
    }
}
