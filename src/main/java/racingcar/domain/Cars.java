package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            car.moveOrNot();
        }
    }

    public List<Car> pickWinner() {
        Car maxPositionCar = findWinner();
        return findSamePositionCars(maxPositionCar);
    }

    private Car findWinner() {
        return cars
                .stream()
                .max(Car::comparePosition)
                .orElseThrow(() -> new IllegalArgumentException("RacingCars가 비어있습니다."));
    }

    private List<Car> findSamePositionCars(Car maxPositionCar) {
        return cars
                .stream()
                .filter(maxPositionCar::isSamePositionCar)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
