package STP_2022.Buoi_6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test_IQ {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        char[][] matrix = new char[4][4];

        for (int i=0; i<4; i++){
            String str = scanner.next();
            for (int j=0; j<4; j++)
                matrix[i][j] = str.charAt(j);
        }

        for (int row=0; row<=2; row++){
            if (check)
                break;

            for (int col=0; col<=2; col++){
                int count_1 = 0, count_2 = 0;
                for (int i=0; i<2; i++)
                    for (int j=0; j<2; j++)
                        if (matrix[row+i][col+j] == '.')
                            count_1++;
                        else count_2++;
                if (count_1 == 3 || count_2 == 3 || count_1 == 4 || count_2 == 4){
                    check = true;
                    break;
                }
            }
        }


        if (check)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
