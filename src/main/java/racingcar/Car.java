package racingcar;

import static mallang.missionutils.Randoms.pickNumberInRange;

public class Car {

    private final String name;
    private int position = 0;
    final int CHECK_MOVE_NUM = 4;
    final int PICK_NUM_RANGE_MIN = 0;
    final int PICK_NUM_RANGE_MAX= 9;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randNum = pickNumberInRange(PICK_NUM_RANGE_MIN,PICK_NUM_RANGE_MAX);
        if (randNum >= CHECK_MOVE_NUM) {
            this.position ++;
        }
    }

    public void status() {
        System.out.printf("%s : ",this.name);
        for (int i=0 ; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }


}
