package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car {

    private final CarName name;
    private CarPostition position;

    public Car(String name) {
        this.name = CarName.of(name);
        this.position = CarPostition.of(0);
    }

    private void move() {
        position = position.increase();
    }

    public void moveOrNot(NumberGenerator numberGenerator) {
        int randomValue = numberGenerator.generate();
        if (randomValue >= 4) {
            move();
        }
    }

    public int comparePosition(Car otherCar) {
        return this.position.compareTo(otherCar.position);
    }

    public boolean isSamePositionCar(Car car) {
        return this.position.equals(car.position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
