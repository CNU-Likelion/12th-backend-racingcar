package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;

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
        }
    }
}
