package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceOfficialTest {
    @DisplayName("우승자 도출 테스트")
    @Test
    void findWinners() {
        List<Car> cars = new ArrayList<>(
                List.of(new Car("pobi"), new Car("jun"))
        );
        cars.get(0).race(4);
        cars.get(1).race(4);
        RaceOfficial raceOfficial = new RaceOfficial();
        List<String> winners = raceOfficial.findWinners(cars);
        assertThat(winners).containsExactly("pobi", "jun");
    }
}
