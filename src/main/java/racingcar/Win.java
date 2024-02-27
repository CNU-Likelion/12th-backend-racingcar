package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Win {
	private static int maxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			if (maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}

	private static List<String> findWinnerNames(List<Car> cars) {
		int maxPosition = maxPosition(cars);
		List<String> winnerNames = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winnerNames.add(car.getName());
			}
		}
		return winnerNames;
	}

	public static void printWinnerNames(List<Car> cars) {
		List<String> winnerNames = findWinnerNames(cars);
		System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
	}
}