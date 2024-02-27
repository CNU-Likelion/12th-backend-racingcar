package racingcar.util;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarValidator {

    private static final String INVALID_NAME_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이내의 이름이어야 합니다.";

    public static boolean validate(List<String> names) {
        try {
            validateNameLength(names);
            return true;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            InputView.getCarNames();
            return false;
        }
    }

    private static void validateNameLength(List<String> names) {
        boolean inValidCondition = names.stream().anyMatch(name -> name.length() > 5);
        if (inValidCondition) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }
}
