package racingcar;

public class Application {

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        String[] userName = inputGetter.getUserName();
        int numberOfTry = inputGetter.getNumberOfTry();

        RaceGame raceGame = new RaceGame(userName);
        raceGame.doGame(numberOfTry);
    }
}
