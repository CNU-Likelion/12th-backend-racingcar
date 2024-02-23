package racingcar.domain;

import racingcar.domain.vo.Name;
import racingcar.domain.vo.Position;

public class Car {

    private static final int INITIAL_CAR_POSITION = 0;
    private static final int MOVING_CRITERIA = 4;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(INITIAL_CAR_POSITION);
    }

    public void move(final int movingPoint) {
        if (movingPoint >= MOVING_CRITERIA) {
            position = position.increase();
        }
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }
}
