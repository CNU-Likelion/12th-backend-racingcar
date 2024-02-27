package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행

        User user = new User();
        GameResult result= new GameResult();

        user.getCarName();
        user.getGameCnt();

        user.makeCars();

        System.out.println("실행 결과");

        for (int i=0 ; i<user.gameCnt; i++) {
            for (Car c: user.cars) {
                c.move();
            }
            for (Car c: user.cars) {
                c.status();
            }
            System.out.println();
        }

        result.addWinnerCars(user.cars);
        result.printGameResult();
    }
}
