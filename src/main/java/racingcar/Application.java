package racingcar;

import mallang.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        String[] userName = inputGetter.getUserName();
        int numberOfTry = inputGetter.getNumberOfTry();

        RaceGame raceGame = new RaceGame(userName);

        for (int i = 0; i < numberOfTry; i++) {
            raceGame.doOneGame();
        }

    }
}
