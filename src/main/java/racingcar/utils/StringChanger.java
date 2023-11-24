package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {
    private static final int INCLUDING_LAST_BLANK = -1;
    private static final int START_OF_STRING = 0;

    private StringChanger() {
    }

    public static List<String> toTrimmedStringList(String input, String separator) {
        return Arrays.stream(
                        input.split(separator, INCLUDING_LAST_BLANK))
                .map(String::trim).collect(Collectors.toList()
                );
    }

    public static int toInteger(String input) {
        ArgumentValidator.isNumber(input);
        return Integer.parseInt(input);
    }

    public static String cutLastRegex(StringBuilder stringBuilder, String regex) {
        int cutLength = stringBuilder.length() - regex.length();
        return stringBuilder.substring(START_OF_STRING, cutLength);
    }

}
