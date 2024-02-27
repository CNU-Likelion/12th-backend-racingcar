package racingcar.domain;

import racingcar.view.OutputView;

public final class CarName {

    private static final String INVALID_NAME_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자 이내의 이름이어야 합니다.";
    private String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validateNameLength(name);
        return new CarName(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
