package racingcar.test;

import racingcar.domain.NumberGenerator;

public class MovingNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 4;
    }
}
