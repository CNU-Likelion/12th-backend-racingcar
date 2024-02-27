package racingcar.domain;

public final class CarName {

    private String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }
}
