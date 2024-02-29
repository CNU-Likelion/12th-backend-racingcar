package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0~9까지의 랜덤한 수를 생성한다.")
    void generate() {
        // given
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        final int generatedNumber = randomNumberGenerator.generate();

        // then
        Assertions.assertThat(generatedNumber).isBetween(0, 9);
    }
}
