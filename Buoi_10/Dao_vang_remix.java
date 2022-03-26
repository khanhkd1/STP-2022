package STP_2022.Buoi_10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Dao_vang_remix {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase=0; testCase<testCases; testCase++){
            int R = scanner.nextInt(), C = scanner.nextInt();
            int[][] matrix = new int[R][C];
            for (int row=0; row<R; row++){
                String[] chars = scanner.next().split("");
                for (int col=0; col<C; col++){
                    matrix[row][col] = Integer.parseInt(chars[col]);
                }
            }
            int countRow = 0, countCol = 0;
            for (int row=0; row<R; row++)
                for (int col=0; col<C; col++){
                    if (matrix[row][col] == 1)
                        break;
                    if (col == C-1)
                        countRow++;
                }
            for (int col=0; col<C; col++)
                for (int row=0; row<R; row++){
                    if (matrix[row][col] == 1)
                        break;
                    if (row == R-1)
                        countCol++;
                }
            System.out.println("#" + (testCase + 1) + " " + (countRow*C + countCol*R - countRow * countCol));
//            System.out.println(countRow);
//            System.out.println(countCol);
//            for (int row=0; row<R; row++)
//                System.out.println(Arrays.toString(matrix[row]));
        }
    }
}
