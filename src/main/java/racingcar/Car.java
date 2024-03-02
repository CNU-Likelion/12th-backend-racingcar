package racingcar;

import mallang.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void moveForward() {
        int move = Randoms.pickNumberInRange(0,9);
        if(move >= MOVE_THRESHOLD) {
            position += 1;
        }
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
