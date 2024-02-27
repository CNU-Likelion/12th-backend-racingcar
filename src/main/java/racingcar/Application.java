package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행

        //필요한 클래스 객체 생성
        User user = new User();
        GameResult result= new GameResult();

        //사용자로부터 입력 받기
        user.getCarName();
        user.getGameCnt();
        //자동차 객체 생성
        user.makeCars();

        System.out.println("실행 결과");

        // n 번의 게임 진행 후 진행 마다 출력
        for (int i=0 ; i<user.gameCnt; i++) {
            //전진
            for (Car c: user.cars) {
                c.move();
            }

            //출력
            for (Car c: user.cars) {
                c.status();
            }
            System.out.println();

        }

        //최종 우승자 결과 찾기
        result.addWinnerCars(user.cars);
        result.printGameResult();
    }
}
