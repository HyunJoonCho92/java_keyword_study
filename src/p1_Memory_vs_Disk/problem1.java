package p1_Memory_vs_Disk;

import java.util.Random;

public class problem1 {
    public static void main(String[] args) {

        // 1번) “100 이하”의 랜덤 숫자를 1000만개를 생성하고 변수에 저장하세요.
        //      그리고 전체 값을 sum하는 프로그램을 작성하세요.
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        long sum = 0;
        int count = 10000000;

        for (int i = 0; i < count; i++) {
            int number = random.nextInt(101); // 랜덤 숫자
            sum += number;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total sum: " + sum);
        System.out.println("Execution time: " + (endTime - startTime) + " ms"); // 90~100ms 정도 찍힙니다
    }
}
