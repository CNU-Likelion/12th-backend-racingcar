package racingcar;

public class RaceGame {
    private static Car[] racingCars;

    RaceGame(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            racingCars[i] = new Car(userName[i]);
        }
    }
}
