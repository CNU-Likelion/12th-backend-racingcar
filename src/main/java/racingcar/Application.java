package racingcar;
import java.util.*;
import mallang.missionutils.Randoms;
import mallang.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
    }

    public static class Input {
        List<Car> cars = new ArrayList<>();
        int attempt = inputAttempt();
    }

    public static void startGame() {
        List<Car> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = mallang.missionutils.Console.readLine();
        String[] names = carName.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하여야한다.");
                return;
            }
            cars.add(new Car(name));
        }

        System.out.println("시도 할 횟수");
        String attemptInput = mallang.missionutils.Console.readLine();
        int attempt;
        try {
            attempt = Integer.parseInt(attemptInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
    public static void inputGameCnt() {}
    public static void printProgress(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
    public static void printResult(List<Car> cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(",");
                }
                winners.append(car.getName());
            }
        }
        if (winners.toString().contains(",")) {
            System.out.println("최종 우승자: " + winners);
        } else {
            System.out.println("최종 우승자: " + winners);
        }
    }
}
