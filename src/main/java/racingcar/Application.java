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

        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();
        return Integer.parseInt(tryCountInput);
    }
}
