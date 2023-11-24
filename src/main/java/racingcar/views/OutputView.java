package racingcar.views;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.StringChanger;

public class OutputView {
    private static final String DISTANCE_MARKER = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private OutputView() {
    }

    public static void printPrefaceOfResult() {
        System.out.println(LINE_SEPARATOR + "실행 결과");
    }

    public static void printResultOfRound(List<Car> cars) {
        StringBuilder resultOfRound = new StringBuilder();
        for (Car car : cars) {
            resultOfRound.append(car.getName()).append(" : ")
                    .append(DISTANCE_MARKER.repeat(car.getPosition()))
                    .append(LINE_SEPARATOR);
        }
        System.out.println(resultOfRound);
    }

    public static void printWinners(List<String> winnerNames) {
        StringBuilder winners = new StringBuilder(LINE_SEPARATOR + "최종 우승자 : ");
        for (String winnerName : winnerNames) {
            winners.append(winnerName).append(WINNER_SEPARATOR);
        }
        System.out.println(StringChanger.cutLastRegex(winners, WINNER_SEPARATOR));
    }
}
