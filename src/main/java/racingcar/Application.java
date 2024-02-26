package racingcar;

import mallang.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
        try {
            List<Car> cars = initializeCars();
            int tryCount = getTryCount();

            race(cars, tryCount);

            printRaceResult(cars);
            printWinners(checkWinner(cars));
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private static List<Car> initializeCars() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();
            try {
                validateCarNames(carNamesInput);
                String[] carNames = carNamesInput.split(",");
                List<Car> cars = new ArrayList<>();

                for (String carName : carNames) {
                    cars.add(new Car(carName));
                }

                return cars;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static void validateCarNames(String carNames) {
        if (!carNames.matches("[a-zA-Z]+(,[a-zA-Z]+)*")) {
            throw new IllegalArgumentException("자동차 이름은 영문자로만 구분하여 입력하세요.");
        }
    }

    private static int getTryCount() {
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String tryCountInput = Console.readLine();
            try {
                validateTryCount(tryCountInput);
                return Integer.parseInt(tryCountInput);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
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

    private static void printWinners(List<String> winners) {
        System.out.print("\n최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

}
