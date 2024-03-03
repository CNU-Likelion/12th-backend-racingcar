package racingcar;

import mallang.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }
}
