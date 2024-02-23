package racingcar;

import java.util.List;
import java.util.function.Supplier;
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
        final Cars cars = repeatInput(() -> {
            final String racingCarNames = inputView.getRacingCarNames();
            return Cars.from(racingCarNames);
        });
        final int trial = repeatInput(inputView::getTrial);

        race(trial, cars);
        final List<String> winners = cars.getWinners();
        outputView.printWinners(winners);
    }

    private void race(final int trial, final Cars cars) {
        outputView.printProcessingResult();
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < trial; i++) {
            cars.race(randomNumberGenerator);
            outputView.printCurrentCarPositions(cars.getCarNames(), cars.getCarPositions());
        }
    }

    private <T> T repeatInput(final Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (final IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
