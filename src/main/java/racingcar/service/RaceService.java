package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceOfficial;
import racingcar.utils.ArgumentValidator;
import racingcar.utils.StringChanger;

public class RaceService {
    private static final int FIRST_ROUND = 1;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private int numberOfRounds;
    private final RaceOfficial raceOfficial = new RaceOfficial();

    public void setCars(String userInput) {
        raceOfficial.setCars(userInput);
    }

    public List<Car> getCars() {
        return raceOfficial.getCars();
    }

    public void setRounds(String userInput) {
        int numberOfRounds = StringChanger.toInteger(userInput);
        validateNumberOfRounds(numberOfRounds);
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void raceCars() {
        for (Car car : raceOfficial.getCars()) {
            car.race(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
    }

    public List<String> getWinners() {
        return raceOfficial.findWinners();
    }

    private void validateNumberOfRounds(int numberOfRounds) {
        ArgumentValidator.isNotLessThan(numberOfRounds, FIRST_ROUND);
    }
}
