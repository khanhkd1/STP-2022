package STP_2022.Buoi_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Adding_Reversed_Numbers {
    static int reversed_num(int num){
        int reversed = 0;
        while (num != 0){
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<testCase; i++){
            String[] num_array = scanner.nextLine().split(" ");
            System.out.println(reversed_num(reversed_num(Integer.parseInt(num_array[0])) +
                    reversed_num(Integer.parseInt(num_array[1]))));
        }
    }
}
