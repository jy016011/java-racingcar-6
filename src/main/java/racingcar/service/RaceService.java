package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.ArgumentValidator;
import racingcar.utils.StringChanger;

public class RaceService {
    private static final int FIRST_ROUND = 1;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private List<Car> cars;
    private int numberOfRounds;

    public void setCars(String userInput) {
        List<String> carNames = StringChanger.toTrimmedStringList(userInput, ",");
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
        for (Car car : cars) {
            car.race(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
    }

    private void validateCarNames(List<String> carNames) {
        ArgumentValidator.isUnique(carNames);
    }

    private void validateNumberOfRounds(int numberOfRounds) {
        ArgumentValidator.isNotLessThan(numberOfRounds, FIRST_ROUND);
    }
}
