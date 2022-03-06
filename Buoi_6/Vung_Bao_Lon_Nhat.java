package STP_2022.Buoi_6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vung_Bao_Lon_Nhat {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int t=0; t<testCase; t++){
            int h = scanner.nextInt(), w = scanner.nextInt(), m = scanner.nextInt(), n = scanner.nextInt(), max = 0;
            int[][] matrix = new int[m][n];
            for (int row=0; row<m; row++)
                for (int col=0; col<n; col++)
                    matrix[row][col] = scanner.nextInt();
            for (int row=0; row<=m-h; row++)
                for (int col=0; col<=n-w; col++){
                    int sum = 0;
                    for (int i=0; i<h; i++){
                        if (i==0 || i==h-1)
                            for (int j=0; j<w; j++){
                                if (matrix[row+i][col+j] % 2 == 0) sum += matrix[row+i][col+j];
                            }
                        else {
                            if (matrix[row+i][col] %2 == 0)
                                sum += matrix[row+i][col];
                            if (matrix[row+i][col+w-1] %2 == 0)
                                sum += matrix[row+i][col+w-1];
                        }
                    }
                    if (sum > max)
                        max = sum;
                }
            System.out.println("#" + (t+1) + " " + max);
        }
    }
}
