package racingcar;

import mallang.missionutils.Randoms;

public class RandomNumMaker {
    public int randomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
