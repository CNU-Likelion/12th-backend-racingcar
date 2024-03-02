package racingcar;
import mallang.missionutils.Randoms;
public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
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
