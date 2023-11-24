package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("이름이 1자 이상 5자이하가 아니면 예외가 발생할 것이다.")
    @ValueSource(strings = {"", "po  bi", "joooon"})
    @ParameterizedTest
    void createCarByInvalidLengthName(String userInput) {
        assertThatThrownBy(() -> new Car(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 1자 이상 5자이하면 예외가 발생하지 않을 것이다.")
    @ValueSource(strings = {"j", "pobi", "jun"})
    @ParameterizedTest
    void createCarByValidLengthName(String userInput) {
        assertThatCode(() -> new Car(userInput)).doesNotThrowAnyException();
    }

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

    @DisplayName("멀리간 차량이 더 크다.")
    @Test
    void comparingCars() {
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");
        pobi.race(4);
        jun.race(3);
        assertThat(pobi.compareTo(jun)).isEqualTo(1);
    }

}
