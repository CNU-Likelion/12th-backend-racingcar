package racingcar.domain;

import java.util.Objects;

public final class CarPostition implements Comparable<CarPostition> {

    private final int position;

    private CarPostition(int position) {
        this.position = position;
    }

    public static CarPostition of(int position) {
        return new CarPostition(position);
    }

    public int getPosition() {
        return position;
    }

    public CarPostition add() {
        return CarPostition.of(position + 1);
    }

    @Override
    public int compareTo(CarPostition otherPosition) {
        return this.position - otherPosition.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPostition that = (CarPostition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
