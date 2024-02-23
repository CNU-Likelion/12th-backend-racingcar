package racingcar.domain.vo;

public record Name(String value) {
    public Name {
        validate(value);
    }

    private void validate(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 5 이하만 가능합니다.");
        }
    }
}
