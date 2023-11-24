package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.ArgumentValidator;
import racingcar.utils.StringChanger;

public class RaceOfficial {
    private static final String CAR_NAME_SEPARATOR = ",";
    private List<Car> cars;

    public void setCars(String userInput) {
        List<String> carNames = StringChanger.toTrimmedStringList(userInput, CAR_NAME_SEPARATOR);
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

    public List<String> findWinners() {
        Car maxMovedCar = getMaxMovedCar(cars);
        return cars.stream()
                .filter(maxMovedCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getMaxMovedCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }

    private void validateCarNames(List<String> carNames) {
        ArgumentValidator.isUnique(carNames);
    }
}
