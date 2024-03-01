package racingcar;

import mallang.missionutils.Console;

public class InputGetter {

    public String[] getUserName() {
        InputChecker inputChecker = new InputChecker();
        String[] userNames = readUserName();
        while(true){
            try {
                inputChecker.checkName(userNames);
                return userNames;
            } catch (Exception e) {
                userNames = readUserName();
            }
        }
    }

    private String[] readUserName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return  Console.readLine().split(",");
    }

    public int getNumberOfTry() {
        InputChecker inputChecker = new InputChecker();
        String numberOfTryInput = readNumber();
        while(true){
            try {
                inputChecker.checkNumber(numberOfTryInput);
                return Integer.parseInt(numberOfTryInput);
            } catch (Exception e) {
                numberOfTryInput = readNumber();
            }
        }
    }

    private String readNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}