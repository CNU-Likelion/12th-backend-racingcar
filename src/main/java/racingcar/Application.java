package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행

        Scanner sc = new Scanner(System.in);
        System.out.println("참가자를 입력하세요");
        String users = sc.nextLine();
        String userArr[] = users.split(",");

        System.out.println("시도할 횟수를 입력하세요");
        int N = sc.nextInt();

        for (int i = 0; i < userArr.length; i++) {
            Car cari = new Car(userArr[i]);
            for (int j = 0; j < N; j++) {
                cari.move();
            }
            cari.printPosition();




        }
        //우승자 찾아서 출력





        }

    }

