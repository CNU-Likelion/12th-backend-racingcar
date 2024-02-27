package racingcar;

import mallang.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        
        // 자동차 이름 입력받기
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = Console.readLine();
                String[] names = input.split(",");
                for (String name : names) {
                    if (name.length() > 5) {
                        System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
                        throw new IllegalArgumentException();
                    }
                    cars.add(new Car(name.trim()));
                }
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        // 시도 횟수 입력 받기
        int attempts = 0;
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                attempts = Integer.parseInt(Console.readLine());
                System.out.println("실행 결과");
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
        }

        // 시도 횟수만큼 게임 진행
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
                car.printCarMove(car);
            }
            System.out.println("");
        }
    }
}
