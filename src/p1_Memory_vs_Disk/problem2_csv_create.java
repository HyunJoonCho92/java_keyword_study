package p1_Memory_vs_Disk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class problem2_csv_create {
    public static void main(String[] args) {

        //2번)  csv 파일을 읽어서 전체 수를 sum하는 프로그램을 작성하세요.
        //   csv 파일 내용: “100 이하”의 랜덤 숫자 1000만개를 csv 포맷으로
        //   저장하며 구분자는 “,”입니다. 파일 이름은 임의로 정하세요

        int count = 10000000;
        String fileName = "src/p1_Memory_vs_Disk/random_numbers.csv";

        // csv 파일 생성
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                writer.print(random.nextInt(101));
                if (i < count-1) writer.print(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
