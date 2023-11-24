package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("차량은 난수 값이 4이상이면 전진한다.")
    @Test
    void carMove() {
        Car car = new Car("pobi");
        car.race(4);
        car.race(5);
        car.race(6);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @DisplayName("차량은 난수 값이 4미만이면 움직이지 않는다.")
    @Test
    void carStop() {
        Car car = new Car("pobi");
        car.race(3);
        car.race(2);
        car.race(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
