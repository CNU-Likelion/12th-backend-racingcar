package racingcar;
import java.util.*;
import mallang.missionutils.Randoms;
import mallang.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        input();
        // TODO 구현 진행
    }
    public static void input() {
        List<Car> cars = new ArrayList<>();
        int attempt = inputAttempt();
    }
    public static List<Car> inputCarName() {
        List<Car> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = mallang.missionutils.Console.readLine();
        String[] names = carName.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하여야합니다.");
                return inputCarName();
            }
            cars.add(new Car(name));
        }
        return cars;
    }
    public static int inputAttempt() {
        System.out.println("시도 할 횟수를 입력하세요.");
        String attemptInput = mallang.missionutils.Console.readLine();
        try {
            return Integer.parseInt(attemptInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            return inputAttempt();
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
    public static void findWinners(List<Car> cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        printResult(winners);
    }

}
