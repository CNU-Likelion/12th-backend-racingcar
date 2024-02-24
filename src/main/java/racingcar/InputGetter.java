package racingcar;

import mallang.missionutils.Console;

public class InputGetter {

    public String[] getUserName() {
        InputChecker inputChecker = new InputChecker();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] userName = Console.readLine().split(",");
        try {
            inputChecker.checkName(userName);
        } catch (Exception e) {
            getUserName();
        }
        return userName;
    }

    public int getNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        InputChecker inputChecker = new InputChecker();
        String numberOfTryInput = Console.readLine();
        try {
            inputChecker.checkNumber(numberOfTryInput);
        } catch (Exception e) {
            getNumberOfTry();
        }
        return Integer.parseInt(numberOfTryInput);
    }
}
