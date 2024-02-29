package racingcar;

public class RaceGame {

    private static Car[] racingCars;

    public RaceGame(String[] userName) {
        racingCars = new Car[userName.length];
        for (int i = 0; i < userName.length; i++) {
            racingCars[i] = new Car(userName[i]);
        }
    }

    public void doGame(int numberOfTry) {
        for (int i = 0; i < numberOfTry; i++) {
            doSingleGame();
        }
        selectWinner();
    }

    public void doSingleGame() {
        RandomNumMaker randomNumMaker = new RandomNumMaker();
        AnswerPrinter answerPrinter = new AnswerPrinter();

        for (int i = 0; i < racingCars.length; i++) {
            if (randomNumMaker.randomNum() >= 4) {
                racingCars[i].increasePosition();
            }
        }
        answerPrinter.printEffect(racingCars);
    }

    public void selectWinner() {
        AnswerPrinter answerPrinter = new AnswerPrinter();
        int maxPosition = 0;
        StringBuilder winner = new StringBuilder();
        for (int i = 0; i < racingCars.length; i++) {
            maxPosition = racingCars[i].compareMaxAndPosition(maxPosition);
        }
        for (int i = 0; i < racingCars.length; i++) {
            winner = racingCars[i].addWinner(winner, maxPosition);
        }
        answerPrinter.printWinner(winner);
    }
}