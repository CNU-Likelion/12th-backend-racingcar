package racingcar;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
    }

    public static List<Car> initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        validateCarNames(carNamesInput);

        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static void validateCarNames(String carNames) {
        if (!carNames.matches("[a-zA-Z,]+") || carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 영문자 쉼표(,)로 구분하여 입력하세요.");
        }
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();
        validateTryCount(tryCountInput);
        return Integer.parseInt(tryCountInput);
    }

    public static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
