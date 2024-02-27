package racingcar;

import mallang.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public void printCarInfo(Car car) {
        System.out.print(car.name + " : ");
        for (int i = 0; i < car.position; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
