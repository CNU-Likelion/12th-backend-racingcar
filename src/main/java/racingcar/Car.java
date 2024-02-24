package racingcar;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void IncreasePosition() {
        this.position++;
    }

    public StringBuilder expressCarInfoToString() {
        StringBuilder positionString = new StringBuilder();
        positionString.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString;
    }
}
