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

        int maxPosition = findMaxPosition(cars);

        //우승자 출력
        List<Car> winners = findWinners(cars, maxPosition);
        System.out.println("최종 우승자 : ");
        String winnerNames = winnersToString(winners);
        System.out.println(winnerNames);
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

