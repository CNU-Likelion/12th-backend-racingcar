package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mallang.missionutils.Console.readLine;

public class User {
    List<String> carNames = new ArrayList<>();
    int gameCnt;

    public void getCarName() {
            String[] nameLine = readLine().split(",");
            this.carNames = Arrays.stream(nameLine).toList();
    }

    public void getGameCnt() {
        try {
            this.gameCnt = Integer.parseInt(readLine());

        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            getGameCnt();
        }

    }


}

