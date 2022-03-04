package STP_2022.Buoi_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Number_Steps {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i<n; i++){
            int x = scanner.nextInt(), y = scanner.nextInt();
            if (x == y || (x-y) == 2){
                int step = x/2;
                if (x % 2 == 0){
                    if (x == y)
                        System.out.println(4 * step);
                    else System.out.println(4 * step - 2);
                }
                else {
                    if (x == y)
                        System.out.println(4 * step + 1);
                    else System.out.println(4 * step - 1);
                }
            }
            else System.out.println("No Number");
        }
    }
}
