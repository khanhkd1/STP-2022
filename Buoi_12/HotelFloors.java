package STP_2022.Buoi_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HotelFloors {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase=1; testCase<=testCases; testCase++){
            int m = scanner.nextInt(), n = scanner.nextInt(), countRoom = 0, countPerson = 0;
            char[][] matrix = new char[m][n];
            for (int i=0; i<m; i++){
                String str = scanner.next();
                for (int j=0; j<n; j++)
                    matrix[i][j] = str.charAt(j);
            }

            for (int i=1; i<m-1; i++){
                for (int j=1; j<n-1; j++){
                    if (matrix[i][j] == '#')
                        continue;

                    boolean check = false;
                    while (true){
                        if (j == n-1 || matrix[i][j] == '#'){
                            if (!check)
                                countRoom++;
                            break;
                        }

                        if (matrix[i][j] == '*')
                            countPerson++;

                        if (i>1 && !check)
                            if (matrix[i-1][j] != '#')
                                check = true;

                        j++;
                    }
                }
            }
            System.out.printf("%.2f\n", (double) countPerson/countRoom);
        }
    }
}
