package racingcar;

import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        final var racingGame = new RacingCarController();
        racingGame.start();
    }
}
