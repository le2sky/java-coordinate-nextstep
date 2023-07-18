package coordinate.view;

import coordinate.domain.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputMapper {

    private static final Pattern POINT_NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern POINT_PATTERN = Pattern.compile("\\(\\d+,\\d+\\)");
    private static final String INVALID_POINT_FORMAT_MESSAGE
            = "좌표의 형식은 (x,y) 입니다. 여러 좌표를 입력하시려면 - 를 구분자로 이용해주세요.";
    private static final String SPLIT_DELIMITER = "-";

    public static List<Point> mapToPoints(final String input) {
        List<Point> points = new ArrayList<>();

        for (String target : input.split(SPLIT_DELIMITER)) {
            checkPointInputForm(target);

            points.add(buildPoint(findNumbers(target)));
        }

        return points;
    }

    private static void checkPointInputForm(final String input) {
        Matcher matcher = POINT_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_POINT_FORMAT_MESSAGE);
        }
    }

    private static Point buildPoint(final List<Integer> foundNumbers) {
        checkFoundNumberSize(foundNumbers);

        return Point.of(foundNumbers.get(0), foundNumbers.get(1));
    }

    private static void checkFoundNumberSize(final List<Integer> foundNumbers) {
        if (foundNumbers.size() != 2) {
            throw new IllegalArgumentException(INVALID_POINT_FORMAT_MESSAGE);
        }
    }

    private static List<Integer> findNumbers(final String target) {
        Matcher matcher = POINT_NUMBER_PATTERN.matcher(target);
        List<Integer> foundNumbers = new ArrayList<>();

        while (matcher.find()) {
            foundNumbers.add(Integer.parseInt(matcher.group()));
        }

        return foundNumbers;
    }
}
