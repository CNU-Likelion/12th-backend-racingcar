package racingcar;

import java.util.Random;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class Car {

    private final String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void stringName(){
        if(!String.class.isInstance(name)){
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomNum = new Random().nextInt(10);
        if (randomNum >= 4) {
            position++;
        }
        printPosition();
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}









