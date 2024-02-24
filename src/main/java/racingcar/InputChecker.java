package racingcar;

public class InputChecker {

    public void checkName(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].length() > 5) {
                System.out.println("[ERROR]");
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkNumber(String numberOfTry) {
        try {
            Integer.parseInt(numberOfTry);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
