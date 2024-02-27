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

    public void status() {
        System.out.printf("%s : ",this.name);
        for (int i=0 ; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
