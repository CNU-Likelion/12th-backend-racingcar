package racingcar;

import mallang.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (randomNum >= 4) {
            position++;
        }
    }

    public void printCarMove(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
