package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> cars) {
        createCars(cars);
    }

    private void createCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void raceOneGame() {
        for (Car car : cars) {
            car.moveOrNot(new RandomNumberGenerator());
        }
    }

    public List<Car> pickWinner() {
        Car maxPositionCar = findMaxPosition();
        return findWinners(maxPositionCar);
    }

    private Car findMaxPosition() {
        return cars.stream()
                .max(Car::comparePosition)
                .orElseThrow(() -> new IllegalArgumentException("cars가 비어있습니다."));
    }

    private List<Car> findWinners(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePositionCar)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
