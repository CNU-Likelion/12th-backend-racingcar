package racingcar;

public class InputChecker {

    public void checkName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이내로 입력해주세요.");
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
