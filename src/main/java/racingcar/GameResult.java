package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    List<Car> winners = new ArrayList<>();

    public Car findCandidateCar(Car c1, Car c2) {
        if (c1.getPosition() >= c2.getPosition()) {
            return c1;
        }
        return c2;
    }


}
