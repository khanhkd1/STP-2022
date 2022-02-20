package STP_2022.Buoi_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class soNen {
    static int sum_elements(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0; i<n; i++){
            int num = scanner.nextInt();
            while (true){
                if (sum_elements(num) < 10){
                    System.out.println("#" + (i+1) + " " + sum_elements(num));
                    break;
                }
                num = sum_elements(num);
            }
        }
    }
}
