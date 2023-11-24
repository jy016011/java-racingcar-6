package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceOfficial {
    public List<String> findWinners(List<Car> cars) {
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
}
