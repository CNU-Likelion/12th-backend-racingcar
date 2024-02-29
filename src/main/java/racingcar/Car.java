package racingcar;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increasePosition() {
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

    public int compareMaxAndPosition(int maxPosition) {
        if (maxPosition <= position) {
            return position;
        }
        return maxPosition;
    }

    public StringBuilder addWinner(StringBuilder winner, int position) {
        if (position == this.position) {
            if (winner.length() != 0) {
                winner.append(",");
            }
            winner.append(name);
        }
        return winner;
    }
}
