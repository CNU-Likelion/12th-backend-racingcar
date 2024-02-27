package racingcar;

import java.io.IOException;
import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) throws IOException {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingCarController(carNames, tryCount);
        racingGame.start();
    }
}
