package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    public static void print(final String message) {
        System.out.println(message);
    }

    public static void showCarsPosition(List<Car> cars) {
        StringBuilder carInfo = new StringBuilder();
        cars.forEach(racingCar -> {
            carInfo.append(racingCar.getName()).append(" : ");
            carInfo.append("-".repeat(Math.max(0, racingCar.getPosition()))).append("\n");
        });
        print(carInfo.toString());
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerFormat = winners
                .stream()
                .map(Car::getName)
                .toList();
        System.out.println(String.join(", ", winnerFormat) + "가 최종 우승했습니다.");
    }
}
