package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    String carName;
    Car car;

    @BeforeEach
    void setUp() {
        carName = "XC90";
        car = new Car(carName);
    }

    @Test
    @DisplayName("자동차가 정상적으로 생성된다.")
    void create() {
        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getName()).isEqualTo(carName);
            softly.assertThat(car.getPosition()).isZero();
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    @DisplayName("자동차의 movingPoint가 4이상이면 위치가 1만큼 증가한다.")
    void move(final int movingPoint) {
        // when
        car.move(movingPoint);

        // then
        assertThat(car.getPosition()).isOne();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 0, 1})
    @DisplayName("자동차의 movingPoint가 4보다 작으면 위치가 변경되지 않는다.")
    void moveNot(final int movingPoint) {
        // when
        car.move(movingPoint);

        // then
        assertThat(car.getPosition()).isZero();
    }
}
