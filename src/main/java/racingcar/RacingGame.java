package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final String racingCarNames = inputView.getRacingCarNames();
        final int trial = inputView.getTrial();
        final Cars cars = Cars.from(racingCarNames);

        outputView.printProcessingResult();
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < trial; i++) {
            cars.race(randomNumberGenerator);
            outputView.printCurrentCarPositions(cars.getCarNames(), cars.getCarPositions());
        }

        final List<String> winners = cars.getWinners();
        outputView.printWinners(winners);
    }

    private Cars getRacingCars() {
        try {
            final String racingCarNames = inputView.getRacingCarNames();
            return Cars.from(racingCarNames);
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRacingCars();
        }
    }
}
