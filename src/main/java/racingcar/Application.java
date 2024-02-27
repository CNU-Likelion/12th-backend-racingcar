package racingcar;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        getUserInput();
    }

    private static void getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        System.out.println("시도할 횟수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
    }
}
