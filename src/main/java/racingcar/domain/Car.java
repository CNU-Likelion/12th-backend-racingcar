package racingcar.domain;

import racingcar.domain.vo.Name;
import racingcar.domain.vo.Position;

public class Car {

    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void move(final int movingPoint) {
        if (movingPoint >= 4) {
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
