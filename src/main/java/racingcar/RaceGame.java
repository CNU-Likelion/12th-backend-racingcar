package racingcar;

import mallang.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private List<Car> cars;
    
    private static List<Car> initializeCars() {
        while (true) {
            System.out.println(Messages.RACING_CAR_NAME_INPUT);
            String carNamesInput = Console.readLine();
            try {
                String[] carNames = carNamesInput.split(",");
                List<Car> cars = new ArrayList<>();

                for (String carName : carNames) {
                    cars.add(new Car(carName));
                    validateCarNames(carName);
                }

                return cars;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static void validateCarNames(String carNames) {
        if (!carNames.matches("^[a-zA-Z]{1,5}$")) {
            throw new IllegalArgumentException(Messages.CAR_NAME_ENGLISH_ONLY);
        }
    }

    private static int getTryCount() {
        while (true) {
            System.out.println(Messages.TRY_COUNT);
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
            throw new IllegalArgumentException(Messages.TRY_COUNT_NUMBER_ONLY);
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
        System.out.println(Messages.RESULT);

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
        System.out.print(Messages.WINNER);
        System.out.println(String.join(", ", winners));
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
