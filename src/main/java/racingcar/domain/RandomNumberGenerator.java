package racingcar.domain;

import mallang.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MINIMUM_MOVING_POINT = 0;
    private static final int MAXIMUM_MOVING_POINT = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_MOVING_POINT, MAXIMUM_MOVING_POINT);
    }
}
