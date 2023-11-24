package racingcar.views;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class OutputViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void reset() {
        System.setOut(standardOut);
        captor.reset();
    }

    private String output() {
        return captor.toString();
    }


    @DisplayName("라운드 결과 출력 확인")
    @Test
    void printResultOfRound() {
        List<Car> cars = new ArrayList<>(List.of(new Car("pobi"), new Car("jun")));
        cars.get(0).race(4);
        cars.get(1).race(3);
        OutputView.printResultOfRound(cars);
        assertThat(output()).contains("pobi : -", "jun : ");
    }
}
