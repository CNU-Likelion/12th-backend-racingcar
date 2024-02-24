package racingcar;

public class RaceGame {
    private static Car[] racingCars;

    public RaceGame(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            racingCars[i] = new Car(userName[i]);
        }
    }

    public void doOneGame() {
        RandomNumMaker randomNumMaker = new RandomNumMaker();

        for (int i = 0; i < racingCars.length; i++) {
            if (randomNumMaker.RandomNum() >= 4) {
                racingCars[i].IncreasePosition();
            }
        }
    }

}
