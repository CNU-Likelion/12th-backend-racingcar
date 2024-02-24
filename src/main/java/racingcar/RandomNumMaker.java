package racingcar;

import mallang.missionutils.Randoms;

public class RandomNumMaker {

    public int RandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
