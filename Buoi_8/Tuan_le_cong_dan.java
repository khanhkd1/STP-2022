package STP_2022.Buoi_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tuan_le_cong_dan {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        char[][] matrix = new char[m][n];
        for (int row=0; row<m; row++){
            String str = scanner.next();
            for (int col=0; col<n; col++)
                matrix[row][col] = str.charAt(col);
        }
        int i=0, j=0, max=0, count;
        for (int row=0; row<m; row++)
            for (int col=0; col<n; col++){
                if (matrix[row][col] == 'o')
                    continue;

                count=0;
                for (int ngang=col-1; ngang<=col+1; ngang++)
                    for (int doc=row-1; doc<=row+1; doc++)
                        if (ngang >= 0 && ngang < n && doc >= 0 && doc < m)
                            if (matrix[doc][ngang] == 'o')
                                count++;
                if (count>=max){
                    max = count;
                    i = row;
                    j = col;
                }
            }
        matrix[i][j] = 'o';
        int batTay = 0;
        for (int row=0; row<m; row++)
            for (int col=0; col<n; col++){
                if (matrix[row][col] == 'o')
                    for (int ngang=col-1; ngang<=col+1; ngang++)
                        for (int doc=row-1; doc<=row+1; doc++){
                            if (ngang==col && doc==row)
                                continue;
                            if (ngang >= 0 && ngang < n && doc >= 0 && doc < m)
                                if (matrix[doc][ngang] == 'o'){
//                                    System.out.println("(" + row + "," + col + ") vs (" + ngang );
                                    batTay++;
                                }

                        }
            }
//        for (int row=0; row<m; row++)
//            System.out.println(Arrays.toString(matrix[row]));
        System.out.println(batTay/2);
    }
}
