package racingcar;

import mallang.missionutils.Console;


public class Application {
    public static void main(String[] args) {
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
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
        }

    }
}
