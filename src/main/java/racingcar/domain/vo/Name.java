package racingcar.domain.vo;

public record Name(String value) {

    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    public Name {
        validate(value);
    }

    private void validate(final String value) {
        if (value.isEmpty() || value.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 1~5까지만 가능합니다.");
        }
    }
}
