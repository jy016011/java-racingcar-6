package racingcar.views;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String DISTANCE_MARKER = "-";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private OutputView() {
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
}
