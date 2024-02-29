package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    public void printProcessingResult() {
        System.out.println(NEW_LINE + "실행결과");
    }

    public void printCurrentCarPositions(final List<String> carNames, final List<Integer> carPositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions.get(i)));
        }
        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        final String winnersConcat = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersConcat);
    }
}
