package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    @DisplayName("이름이 정상적으로 생성된다.")
    void create() {
        // given
        final String value = "저문";

        // when
        final Name name = new Name(value);

        // then
        assertThat(name.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("이름의 길이는 1~5자가 아니면 예외가 발생한다")
    void validateThrowsException(final String input) {
        // when, then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름의 길이는 1~5까지만 가능합니다.");
    }
}
