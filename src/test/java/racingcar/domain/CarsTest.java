package racingcar.domain;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.test.MovingNumberGenerator;

class CarsTest {

    String carNames = "김,나,박,이";
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.from(carNames);
    }

    @Test
    @DisplayName("자동차들이 정상적으로 생성된다.")
    void create() {
        // then
        assertSoftly(softly -> {
            softly.assertThat(cars.getCarNames()).hasSize(4);
            softly.assertThat(cars.getCarPositions()).hasSize(4);
        });
    }

    @Test
    @DisplayName("자동차들이 정상적으로 경주한다.")
    void race() {
        // when
        cars.race(new MovingNumberGenerator());

        // then
        assertSoftly(softly -> {
            softly.assertThat(cars.getCarNames()).hasSize(4);
            softly.assertThat(cars.getCarPositions()).hasSize(4);
            for (final int carPosition : cars.getCarPositions()) {
                softly.assertThat(carPosition).isOne();
            }
        });
    }

    @Test
    @DisplayName("자동차들 중 가장 멀리 이동한 자동차들의 이름을 반환한다.")
    void getWinners() {
        // given
        cars.race(new MovingNumberGenerator());

        // when
        final List<String> winners = cars.getWinners();

        // then
        assertSoftly(softly -> {
            softly.assertThat(winners.get(0)).isEqualTo("김");
            softly.assertThat(winners.get(1)).isEqualTo("나");
            softly.assertThat(winners.get(2)).isEqualTo("박");
            softly.assertThat(winners.get(3)).isEqualTo("이");
        });
    }
}
