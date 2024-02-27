package racingcar;

import static racingcar.Win.*;

import java.util.ArrayList;
import java.util.List;
import mallang.missionutils.Console;
import mallang.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = new ArrayList<>();
        String inputName = Console.readLine();
        String[] names = inputName.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        int gameTurn = getTurn();
        System.out.println("실행 결과");
        for (int i=0 ; i < gameTurn ; i++) {
            for (Car car : cars) {
                car.carMove();
                car.printCarStatus(car);
                System.out.println();
            }
            System.out.println();
        }
        printWinnerNames(cars);

    }
    public static void checkTurn(String gameTurn) {
        if (gameTurn == null || gameTurn.length() == 0) {
            throw new IllegalArgumentException("[ERROR]숫자를 입력해주세요.");
        }
        for (char c : gameTurn.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR]숫자를 입력해주세요.");
            }
        }
    }

    public static void checkNegativeNum(int gameTurn) {
        if (gameTurn <= 0)
            throw new IllegalArgumentException("[ERROR]0보다 큰 숫자를 입력해주세요.");
    }

    public static int getTurn() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNum = Console.readLine();
        checkTurn(inputNum);
        int gameTurn = Integer.parseInt(inputNum);
        checkNegativeNum(gameTurn);
        return gameTurn;
    }
}
