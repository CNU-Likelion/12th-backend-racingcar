package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final RacingGame racingGame = new RacingGame(new InputView(), new OutputView());
        racingGame.start();
    }
}
