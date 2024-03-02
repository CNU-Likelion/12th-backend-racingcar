package racingcar;
import mallang.missionutils.Randoms;
public class Car {
    private static final int MAX = 9;
    private static final int MIN = 0;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(MIN, MAX);
        if (randomNum >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
