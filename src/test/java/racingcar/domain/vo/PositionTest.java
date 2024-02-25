package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치가 정상적으로 증가한다.")
    void increase() {
        // given
        final Position position = new Position(0);

        // when
        final Position newPosition = position.increase();

        // then
        assertThat(newPosition.value()).isOne();
    }
}
