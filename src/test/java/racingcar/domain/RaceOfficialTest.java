package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceOfficialTest {
    @DisplayName("우승자 도출 테스트")
    @Test
    void findWinners() {
        RaceOfficial raceOfficial = new RaceOfficial();
        raceOfficial.setCars("pobi,jun");
        List<String> winners = raceOfficial.findWinners();
        assertThat(winners).containsExactly("pobi", "jun");
    }
}
