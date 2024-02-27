package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    List<Car> winners = new ArrayList<>();

    public int findMaxPositionValue(List<Car> carList) {
        int maxPositionValue = carList.get(0).getPosition();
        for (Car c : carList) {
            if(maxPositionValue < c.getPosition()) {
                maxPositionValue = c.getPosition();
            }
        }
        return maxPositionValue;
    }

    public void addWinnerCars(List<Car> carList) {
        int maxPositionValue = findMaxPositionValue(carList);
        for (Car c:carList) {
            if (c.getPosition() == maxPositionValue) {
                this.winners.add(c);
            }
        }
    }

    public void printGameResult() {
        System.out.print("최종 우승자 : ");
        for (int i=0 ; i<winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size()-1) {
                System.out.print(", ");
            }
        }
    }

}
