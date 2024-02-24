package racingcar;

import mallang.missionutils.Console;

public class InputGetter {

    public String[] getUserName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        InputChecker inputChecker = new InputChecker();
        String[] userName = Console.readLine().split(",");
        for (int i = 0; i < userName.length; i++) {
            inputChecker.checkName(userName[i]);
        }
        return userName;
    }

    public int getNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        InputChecker inputChecker = new InputChecker();
        String numberOfTryInput = Console.readLine();
        inputChecker.checkNumber(numberOfTryInput);
        return Integer.parseInt(numberOfTryInput);
    }
}
