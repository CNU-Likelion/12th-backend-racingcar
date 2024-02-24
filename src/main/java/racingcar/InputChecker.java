package racingcar;

public class InputChecker {

    public void checkName(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].length() > 5) {
                System.out.println("[ERROR] 이름은 5자 이내로 입력하셔야 합니다.");
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
