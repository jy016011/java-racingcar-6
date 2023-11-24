package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.ArgumentValidator;
import racingcar.utils.StringChanger;

public class RaceService {
    private static final int FIRST_ROUND = 1;
    private static final int MIN_NUMBER_OF_CARS = 1;
    private List<Car> cars;

    public void setCars(String userInput) {
        List<String> carNames = StringChanger.toTrimmedStringList(userInput, ",");
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public void runRounds(String userInput) {
        int numberOfRounds = StringChanger.toInteger(userInput);
        validateNumberOfRounds(numberOfRounds);
//        for (int round = FIRST_ROUND; round <= numberOfRounds; round++) {
//            raceCars();
//        }
    }

//    private void raceCars(){
//        for (Car car : cars) {
//            car.race();
//        }
//    }

    private void validateCarNames(List<String> carNames) {
        ArgumentValidator.isUnique(carNames);
    }

    private void validateNumberOfRounds(int numberOfRounds) {
        ArgumentValidator.isNotLessThan(numberOfRounds, FIRST_ROUND);
    }
}
