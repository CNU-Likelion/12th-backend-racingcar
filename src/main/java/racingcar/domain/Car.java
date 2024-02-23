package racingcar.domain;

public class Car {

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.length() > 5) {
            System.out.println(name);
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 5 이하만 가능합니다.");
        }
    }

    public void move(final int movingPoint) {
        if (movingPoint >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
