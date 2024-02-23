package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final RacingGameController racingGameController = new RacingGameController(new InputView(), new OutputView());
        racingGameController.start();
    }
}
