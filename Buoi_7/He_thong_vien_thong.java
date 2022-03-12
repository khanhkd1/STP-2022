package STP_2022.Buoi_7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class He_thong_vien_thong {
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

            for (int row=0; row<m; row++)
                System.out.println(Arrays.toString(matrix[row]));

            for (int row=0; row<m; row++)
                for (int col=0; col<n; col++){
                    if (matrix[row][col] == 'X' || matrix[row][col] == 'H' || matrix[row][col] == 'O')
                        continue;
                    int phuSong;
                    if (matrix[row][col] == 'A')
                        phuSong = 1;
                    else if (matrix[row][col] == 'B')
                        phuSong = 2;
                    else phuSong = 3;
                    for (int ngang=col-phuSong; ngang<=col+phuSong; ngang++)
                        if (ngang >= 0 && ngang < n)
                            if (matrix[row][ngang] == 'H')
                                matrix[row][ngang] = 'O';

                    for (int doc=row-phuSong; doc<=row+phuSong; doc++)
                        if (doc >= 0 && doc < m)
                            if (matrix[doc][col] == 'H')
                                matrix[doc][col] = 'O';
                }
            int count = 0;
            for (int row=0; row<m; row++)
                for (int col=0; col<n; col++)
                    if (matrix[row][col] == 'H')
                        count++;
            System.out.println("#" + (t+1) + " " + count);

            System.out.println();

            for (int row=0; row<m; row++)
                System.out.println(Arrays.toString(matrix[row]));
        }
    }
}
