package racingcar;

import mallang.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private List<Car> cars;

    public void startGame() {
        cars = initializeCars();
        int tryCount = getTryCount();
        race(tryCount);
        printWinners(checkWinner());
    }

    private List<Car> initializeCars() {
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

    private void validateCarNames(String carNames) {
        if (!carNames.matches("^[a-zA-Z]{1,5}$")) {
            throw new IllegalArgumentException(Messages.CAR_NAME_ENGLISH_ONLY);
        }
    }

    private int getTryCount() {
        while (true) {
            System.out.println(Messages.TRY_COUNT);
            String tryCountInput = Console.readLine();
            try {
                return Integer.parseInt(tryCountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(Messages.TRY_COUNT_NUMBER_ONLY);
            }
        }
    }

    private void race(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRaceResult();
        }
    }

    private void printRaceResult() {
        System.out.println(Messages.RESULT);

        for (Car car : cars) {
            StringBuilder result = new StringBuilder(car.getName() + " : ");

            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }

            System.out.println(result.toString());
        }
    }

    private List<String> checkWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int max = 0;

        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }

    private void printWinners(List<String> winners) {
        System.out.print(Messages.WINNER);
        System.out.println(String.join(", ", winners));
    }

    private void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
