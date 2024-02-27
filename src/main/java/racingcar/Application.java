package racingcar;
import java.util.*;
import mallang.missionutils.Randoms;
import mallang.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
    }
    public static void startGame() {
        List <Car> cars = new ArrayList<>();

        String carName = mallang.missionutils.Console.readLine();
        String[] names = carName.split(",");
        for(String name : names) {
            if(name.length() > 5) {
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
}
