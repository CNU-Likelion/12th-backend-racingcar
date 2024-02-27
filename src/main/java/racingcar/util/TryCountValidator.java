package racingcar.util;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class TryCountValidator {

    private static final String INVALID_TRY_COUNT_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String EMPTY_TRY_COUNT_MESSAGE = "[ERROR] 시도 횟수는 빈 공백이어서는 안된다.";

    public static boolean validateTryCount(final String tryCount) {
        try {
            validateInvalidTryCount(tryCount);
            validateEmptyTryCount(tryCount);
            return true;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return false;
        }
    }

    public static void validateInvalidTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public static void validateEmptyTryCount(String tryCount) {
        if (tryCount.isEmpty() || tryCount.isBlank()) {
            throw new IllegalArgumentException(EMPTY_TRY_COUNT_MESSAGE);
        }
    }
}
