package racingcar.view;

import java.util.regex.Pattern;
import mallang.missionutils.Console;

public class InputView {

    private static final Pattern INTEGER_VALIDATION_REGEX = Pattern.compile("^[0-9]+$");

    public String getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        final String input = Console.readLine();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    private void validateInteger(final String input) {
        if (!INTEGER_VALIDATION_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
}
