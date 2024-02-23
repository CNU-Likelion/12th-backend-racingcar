package racingcar.domain.vo;

public record Position(int value) {
    public Position increase() {
        return new Position(value + 1);
    }
}
