package STP_2022.Buoi_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Quan_ma_duoc_chon {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase=0; testCase<testCases; testCase++){
            int N = scanner.nextInt(), K = scanner.nextInt(), M = scanner.nextInt(), D = scanner.nextInt();
            String[][] banCo = new String[N][N];

            for (int i=0; i<K; i++)
                banCo[scanner.nextInt()][scanner.nextInt()] = String.valueOf(i);
            for (int i=0; i<M; i++)
                banCo[scanner.nextInt()][scanner.nextInt()] = "o";
            for (int i=0; i<D; i++)
                banCo[scanner.nextInt()][scanner.nextInt()] = "x";

            int max=0, stt=0, rowReturn=0, colReturn=0;
            for (int row=0; row<N; row++)
                for (int col=0; col<N; col++){
                    if (banCo[row][col] == "o" || banCo[row][col] == "x" || banCo[row][col] == null)
                        continue;
                    else {
                        int count = 0;
                        for (int i=row-2; i<=row+2; i+=4)
                            for (int j=col-1; j<=col+1; j+=2){
                                if (i<0 || i>=N || j<0 || j>=N)
                                    continue;
                                if (banCo[i][j] != "x" && banCo[i][j] != null)
                                    count++;
                            }
                        for (int i=row-1; i<=row+1; i+=2)
                            for (int j=col-2; j<=col+2; j+=4){
                                if (i<0 || i>=N || j<0 || j>=N)
                                    continue;
                                if (banCo[i][j] != "x" && banCo[i][j] != null)
                                    count++;
                            }
                        if (count > max){
                            max = count;
                            stt = Integer.parseInt(banCo[row][col]);
                            rowReturn = row;
                            colReturn = col;
                        }
                        else if (count == max && Integer.parseInt(banCo[row][col]) <= stt){
                            max = count;
                            stt = Integer.parseInt(banCo[row][col]);
                            rowReturn = row;
                            colReturn = col;
                        }
//                        System.out.println("Max: " + max + ", stt: " + stt);
                    }
                }
            System.out.println("#" + (testCase+1) + " " + rowReturn + " " + colReturn + " " + max);


//            for (int row=0; row<N; row++)
//                System.out.println(Arrays.toString(banCo[row]));
//            System.out.println((char) (9 + '0'));
//            System.out.println(banCo[0][0]);
        }
    }
}
