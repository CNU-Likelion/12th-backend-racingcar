package racingcar.view;

import java.util.List;
import mallang.missionutils.Console;
import racingcar.util.CarValidator;
import racingcar.util.TryCountValidator;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void print(final String message) {
        System.out.println(message);
    }

    public static List<String> getCarNames() {
        print(CAR_NAME_INPUT_MESSAGE);
        List<String> carNames = List.of(Console.readLine().split(","));
        if (CarValidator.validate(carNames)) {
            return carNames;
        }
        return getCarNames();
    }

    public static int getTryCount() {
        print(TRY_COUNT_INPUT_MESSAGE);
        String tryCount = Console.readLine();
        if (TryCountValidator.validateTryCount(tryCount)) {
            return Integer.parseInt(tryCount);
        }
        return getTryCount();
    }
}
