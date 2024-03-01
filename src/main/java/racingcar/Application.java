package racingcar;

import mallang.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = getCarNames();
        int attempts = getAttempts();


        // 시도 횟수만큼 게임 진행
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
                car.printCarMove(car);
            }
            System.out.println("");
        }

        int maxPosition = findMaxPosition(cars);

        //우승자 출력
        List<Car> winners = findWinners(cars, maxPosition);
        System.out.print("최종 우승자 : ");
        String winnerNames = winnersToString(winners);
        System.out.print(winnerNames);
    }

    private static List<Car> getCarNames() {
        List<Car> cars = new ArrayList<>();
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String input = Console.readLine();
                String[] names = input.split(",");
                for (String name : names) {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
                    }
                    cars.add(new Car(name.trim()));
                }
                break; // 유효한 입력이 들어온 경우 반복문 종료
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
                // 사용자에게 재입력을 유도하기 위해 다시 반복
            }
        }
        return cars;
    }

    private static int getAttempts() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
        }
    }

    //위치의 최댓값
    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
            }
        }
        return maxPosition;
    }

    // 우승자 판별 메소드
    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static String winnersToString(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }
        return winnerNames.toString();
    }
}

