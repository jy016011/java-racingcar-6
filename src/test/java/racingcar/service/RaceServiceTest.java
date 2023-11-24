package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceServiceTest {
    @DisplayName("입력한 차량들 이름이 중복이거나,"
            + " 차량 대수가 1대미만이거나,"
            + "형식에 안맞거나,"
            + "이름이 1자이상 5자이하가 아니면"
            + "예외가 발생할 것이다.")
    @ValueSource(strings = {"pobi,pobi", "", "pobi.jun", "poobii"})
    @ParameterizedTest
    void createCarsUnderOne(String userInput) {
        RaceService raceService = new RaceService();
        assertThatThrownBy(() -> raceService.setCars(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 회수가 숫자가 아니거나, 1미만의 수라면 예외가 발생할 것이다.")
    @ValueSource(strings = {"12a", "0", "-1"})
    @ParameterizedTest
    void inputInvalidNumberOfRounds(String userInput) {
        RaceService raceService = new RaceService();
        assertThatThrownBy((() -> raceService.runRounds(userInput))).isInstanceOf(IllegalArgumentException.class);
    }
}
