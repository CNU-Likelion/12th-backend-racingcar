package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행

        Cars cars = new Cars();
        GameResult result= new GameResult();

        cars.getCarName();
        cars.getGameCnt();

        cars.makeCars();

        System.out.println("실행 결과");

        for (int i=0 ; i<cars.gameCnt; i++) {
            cars.moveAllCars(cars.cars);
            cars.getAllCarsStatus(cars.cars);
            System.out.println();
        }

        result.addWinnerCars(cars.cars);
        result.printGameResult();
    }
}
