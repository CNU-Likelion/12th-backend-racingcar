package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mallang.missionutils.Console.readLine;

public class User {
    List<String> carNames = new ArrayList<>();
    List<Car> cars = new ArrayList<>();
    int gameCnt;

    public void getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameLine = readLine().split(",");
        this.carNames = Arrays.stream(nameLine).toList();
    }

    public void makeCars() {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void getGameCnt() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            this.gameCnt = Integer.parseInt(readLine());

        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            getGameCnt();
        }

    }


}

