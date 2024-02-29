package racingcar.domain.vo;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
