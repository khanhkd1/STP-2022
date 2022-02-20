package STP_2022.Buoi_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<testCase; i++){
            String[] num_array = scanner.nextLine().split(" ");
            for (int j=2; j<Integer.parseInt(num_array[0]); j++)
                if ((j % Integer.parseInt(num_array[1]) == 0) && (j % Integer.parseInt(num_array[2]) != 0))
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}
