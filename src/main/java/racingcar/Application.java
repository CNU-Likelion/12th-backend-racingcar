package racingcar;

import mallang.missionutils.Console;

public class Application {
    private static void getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getUserName();
        System.out.println("시도할 회수는 몇회인가요?");
        getNumberOfTry();
    }

    private static void getUserName() {
        String[] UserArr = Console.readLine().split(",");
    }

    private static void getNumberOfTry() {
        int numberOfTry = Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args) {
        getUserInput();
    }
}
