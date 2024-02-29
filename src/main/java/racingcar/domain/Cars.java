package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";
    private static final int INITIAL_CAR_POSITION = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String carNames) {
        final List<Car> cars = Arrays.stream(carNames.split(DELIMITER))
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public void race(final NumberGenerator numberGenerator) {
        for (final Car car : cars) {
            final int movingPoint = numberGenerator.generate();
            car.move(movingPoint);
        }
    }

    public List<String> getWinners() {
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_CAR_POSITION);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}
