package racingcar;

import static mallang.missionutils.Randoms.pickNumberInRange;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randNum = pickNumberInRange(0,9);
        if (randNum >= 4) {
            this.position ++;
        }
    }



}
