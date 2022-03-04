package STP_2022.Buoi_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class To_and_Fro {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int col;
        while ((col = scanner.nextInt()) != 0){
            String str = scanner.next();
            int row = str.length() / col;

            char[][] charArray = new char[row][col];
            for (int i=0; i<row; i++)
                for (int j=0; j<col; j++){
                    if (i%2==0)
                        charArray[i][j] = str.charAt(col*i + j);
                    else charArray[i][col-j-1] = str.charAt(col*i + j);
                }

            StringBuilder result = new StringBuilder();
            for (int j=0; j<col; j++)
                for (int i=0; i<row; i++)
                    result.append(charArray[i][j]);
            System.out.println(result);
        }
    }
}
