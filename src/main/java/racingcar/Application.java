package racingcar;

import mallang.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startRace();
    }

    private static void startRace() {
        List<Car> cars = getCars();
        System.out.println("시도할 횟수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        ResultPrinter resultPrinter = new ResultPrinter();

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
                resultPrinter.printCarInfo(car);
            }
            System.out.println("");
        }
        List<String> winners = getWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true) {
            try {
                String[] carNames = Console.readLine().split(",");
                validateNames(carNames);

                List<Car> cars = new ArrayList<>();
                for (String name : carNames) {
                    cars.add(new Car(name));
                }
                return cars;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
