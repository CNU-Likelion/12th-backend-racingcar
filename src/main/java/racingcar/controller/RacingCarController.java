package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RacingCarController {

    private final int tryCount;
    private final Cars cars;

    public RacingCarController(List<String> carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void start() {
        for (int i=0; i<tryCount; i++) {
            cars.raceOneGame();
            OutputView.showCarsPosition(cars.getCars());
        }
        OutputView.showCarsPosition(cars.getCars());
        OutputView.printWinners(getWinners());
    }

    public List<Car> getWinners() {
        return cars.pickWinner();
    }
}
