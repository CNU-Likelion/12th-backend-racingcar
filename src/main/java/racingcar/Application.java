package racingcar;

import static org.mockito.ArgumentMatchers.intThat;

import mallang.missionutils.Console;

public class Application {
    private static String[] userName;
    private static int numberOfTry;

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        String[] userName = inputGetter.getUserName();
        int numberOfTry = inputGetter.getNumberOfTry();
    }
}
