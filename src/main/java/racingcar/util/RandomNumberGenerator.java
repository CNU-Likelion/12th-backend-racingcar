package racingcar.util;

import mallang.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int RANDOM_NUMBER_LOWER_BOUND = 0;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND);
    }
}
