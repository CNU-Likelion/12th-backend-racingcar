package racingcar;

public class PrintStatus {
	public static void printCarStatus(Car car) {
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");

		}
	}
}
