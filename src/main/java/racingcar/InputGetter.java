package racingcar;

import mallang.missionutils.Console;

public class InputGetter {

    public String[] getUserName() {
        InputChecker inputChecker = new InputChecker();
        String[] userName = readUserName();
        while(true){
            try {
                inputChecker.checkName(userName);
                return userName;
            } catch (Exception e) {
                userName = readUserName();
            }
        }
    }

    static String[] readUserName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return  Console.readLine().split(",");
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