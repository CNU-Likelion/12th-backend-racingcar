package racingcar;
import mallang.missionutils.Randoms;
public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkCarName(name);
        this.name = name;
        this.position = 0;
    }

    public void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]5자 이하의 이름을 입력하시오.");
        }
    }

    public void checkEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR]이름을 입력하시오.");
        }
    }

    public void checkCarName(String name) {
        checkEmpty(name);
        checkLength(name);
    }

    public void carMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
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

    public void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i=0 ; i<car.getPosition() ; i++) {
            System.out.print("-");
        }
    }
}
