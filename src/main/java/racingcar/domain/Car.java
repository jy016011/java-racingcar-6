package racingcar.domain;

import racingcar.utils.ArgumentValidator;

public class Car implements Comparable<Car> {
    private final static int MOVING_FORWARD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    public void race(int determiner) {
        if (determiner >= MOVING_FORWARD) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    private void validate(String name) {
        ArgumentValidator.isNotLessThan(name.length(), 1);
        ArgumentValidator.isNotGreaterThan(name.length(), 5);
    }
}
