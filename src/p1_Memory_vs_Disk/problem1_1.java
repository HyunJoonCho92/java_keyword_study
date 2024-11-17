package p1_Memory_vs_Disk;

import java.util.Random;

public class problem1_1 {

    public static void main(String[] args) {
        // 1번) 전체 값을 sum하는 로직을 100회 반복하도록 변경해보세요.
        //      참고로 랜덤 숫자 생성은 반복하지 않습니다.

        long startTime = System.currentTimeMillis();

        int count = 10000000;
        int[] numbers = new int[count];
        Random random = new Random();
        for(int i = 0 ; i < count;i++) {
            numbers[i] = random.nextInt(101);
        }

        for(int i = 0 ; i < 100; i++) {
            long sum = 0;
            for(int j = 0 ; j < count;j++) {
                sum += numbers[j];
            }
            System.out.println("Total sum: " + sum);
        }


        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms"); // 450~500ms 정도 찍힙니다


    }
}
