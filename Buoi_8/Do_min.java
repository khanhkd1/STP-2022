package STP_2022.Buoi_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Do_min {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t=0; t<testCase; t++){
            int m = scanner.nextInt(), n = scanner.nextInt();
            char[][] matrix = new char[m][n];
            for (int row=0; row<m; row++){
                String str = scanner.next();
                for (int col=0; col<n; col++)
                    matrix[row][col] = str.charAt(col);
            }

            int count = 0;
            for (int row=0; row<m; row++)
                for (int col=0; col<n; col++){
                    if (matrix[row][col] == '*')
                        continue;

                    for (int ngang=col-1; ngang<=col+1; ngang++)
                        for (int doc=row-1; doc<=row+1; doc++)
                            if (ngang >= 0 && ngang < n && doc >= 0 && doc < m)
                                if (matrix[doc][ngang] == '*')
                                    count++;
                }

            System.out.println("Case #" + (t+1) + ": " + count);
        }
    }
}
