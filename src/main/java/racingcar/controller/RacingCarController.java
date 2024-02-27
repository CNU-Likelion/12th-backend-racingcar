package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private int tryCount;
    private Cars cars;

    public RacingCarController() {
        initCars();
        initTryCount();
    }

    private void initCars() {
        try {
            List<String> carNames = InputView.getCarNames();
            this.cars = new Cars(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            initCars();
        }
    }

    private void initTryCount() {
        try {
            String tryCount = InputView.getTryCount();
            TryCountValidator.validateTryCount(tryCount);
            this.tryCount = Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            initTryCount();
        }
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
