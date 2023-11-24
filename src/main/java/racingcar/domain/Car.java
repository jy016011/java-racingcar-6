package racingcar.domain;

public class Car {
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

    public void race(int determiner) {
        if (determiner >= MOVING_FORWARD) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    private void validate(String name) {

    }
}
