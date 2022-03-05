package STP_2022.Buoi_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class He_thong_phan_tich_rem_cua {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i=0; i<t; i++){
            int m = scanner.nextInt(), n = scanner.nextInt();
            StringBuilder input = new StringBuilder();
            for (int k=0; k<(m*5 + 1); k++)
                input.append(scanner.next());
            char[][] charsMatrix = new char[5*m+1][5*n+1];
            int index = 0;
            for (int row=0; row<5*m+1; row++)
                for (int col=0; col<5*n+1; col++){
                    charsMatrix[row][col] = input.charAt(index);
                    index++;
                }
            int[] result = {0, 0, 0, 0, 0};
            for (int row=0; row<m; row++)
                for (int col=0; col<n; col++){
                    String matrixString = "";
                    for (int subRow=row*5+1; subRow<row*5+5; subRow++)
                        for (int subCol=col*5+1; subCol<col*5+5; subCol++)
                            matrixString += charsMatrix[subRow][subCol];
                    int type = matrixString.replace(".", "").length();
                    if (type==0)
                        result[0]++;
                    else if (type==4)
                        result[1]++;
                    else if (type==8)
                        result[2]++;
                    else if (type==12)
                        result[3]++;
                    else result[4]++;
                }
            System.out.print("#" + (i+1) + " ");
            for (int j : result) System.out.print(j + " ");
            System.out.println();
        }
    }
}
