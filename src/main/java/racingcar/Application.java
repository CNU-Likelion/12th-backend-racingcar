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
        if (!isValidName(carNames)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
    }

    private static boolean isValidName(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return true;
    }
}
