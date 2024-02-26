package racingcar;

import mallang.missionutils.Console;
import mallang.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
    }

    private static List<Car> initializeCars() {
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

    private static void validateCarNames(String carNames) {
        if (!carNames.matches("[a-zA-Z,]+") || carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 영문자 쉼표(,)로 구분하여 입력하세요.");
        }
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();
        validateTryCount(tryCountInput);
        return Integer.parseInt(tryCountInput);
    }

    private static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void race(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    private static void printRaceResult(List<Car> cars) {
        System.out.println("\n실행 결과");

        for (Car car : cars) {
            StringBuilder result = new StringBuilder(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }

            System.out.println(result.toString());
        }
    }

    private static List<String> checkWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }

    
}
