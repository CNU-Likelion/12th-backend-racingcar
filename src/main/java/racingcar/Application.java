package racingcar;

import mallang.missionutils.Console;

public class Application {
    private static String[] userArr;
    private static int numberOfTry;

    private static void getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getUserName();
        System.out.println("시도할 회수는 몇회인가요?");
        getNumberOfTry();
    }

    private static void getUserName() {
        InputChecker inputChecker = new InputChecker();
        String[] userArr = Console.readLine().split(",");
        for (int i = 0; i < userArr.length; i++) {
            inputChecker.checkName(userArr[i]);
        }
    }

    private static void getNumberOfTry() {
        InputChecker inputChecker = new InputChecker();
        String numberOfTryInput = Console.readLine();
        inputChecker.checkNumber(numberOfTryInput);
        numberOfTry = Integer.parseInt(numberOfTryInput);
    }

    public static void main(String[] args) {
        getUserInput();
    }
}
