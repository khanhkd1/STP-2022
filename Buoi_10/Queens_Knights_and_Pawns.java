package STP_2022.Buoi_10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Queens_Knights_and_Pawns {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), k, count, testCase = 0;
        while (n != 0 && m != 0){
            // input
            char[][] matrix = new char[n][m];
            k = scanner.nextInt();
            count = n * m - k;
            for (int i=0; i<k; i++)
                matrix[scanner.nextInt()-1][scanner.nextInt()-1] = 'Q';
            k = scanner.nextInt();
            count -= k;
            for (int i=0; i<k; i++)
                matrix[scanner.nextInt()-1][scanner.nextInt()-1] = 'K';
            k = scanner.nextInt();
            count -= k;
            for (int i=0; i<k; i++)
                matrix[scanner.nextInt()-1][scanner.nextInt()-1] = 'P';
            // end input

            for (int row=0; row<n; row++){
                for (int col=0; col<m; col++){
                    if (matrix[row][col] == 'K'){
                        for (int subRow=row-2; subRow<=row+2; subRow+=4){
                            for (int subCol=col-1; subCol<=col+1; subCol+=2){
                                if (subRow<0 || subRow>=n || subCol<0 || subCol>=m)
                                    continue;
                                if (matrix[subRow][subCol] != 'K' && matrix[subRow][subCol] != 'Q' && matrix[subRow][subCol] != 'P' && matrix[subRow][subCol] != 'x'){
                                    matrix[subRow][subCol] = 'x';
                                    count--;
                                }
                            }
                        }

                        for (int subRow=row-1; subRow<=row+1; subRow+=2){
                            for (int subCol=col-2; subCol<=col+2; subCol+=4){
                                if (subRow<0 || subRow>=n || subCol<0 || subCol>=m)
                                    continue;
                                if (matrix[subRow][subCol] != 'K' && matrix[subRow][subCol] != 'Q' && matrix[subRow][subCol] != 'P' && matrix[subRow][subCol] != 'x'){
                                    matrix[subRow][subCol] = 'x';
                                    count--;
                                }
                            }
                        }
                    }

                    else if (matrix[row][col] == 'Q'){
                        boolean checkStop1 = false, checkStop2 = false, checkStop3 = false, checkStop4 = false, checkStop5 = false, checkStop6 = false, checkStop7 = false, checkStop8 = false;
                        for (int sub=1; sub<Math.max(Math.max(row, n-row), Math.max(col, m-col)); sub++){
                            if (!checkStop1){
                                if ((row-sub < 0) || (col-sub < 0) || matrix[row-sub][col-sub] == 'K' || matrix[row-sub][col-sub] == 'Q' || matrix[row-sub][col-sub] == 'P')
                                    checkStop1=true;
                                else if (matrix[row-sub][col-sub] != 'x'){
                                    matrix[row-sub][col-sub] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop2){
                                if ((row-sub < 0) || matrix[row-sub][col] == 'K' || matrix[row-sub][col] == 'Q' || matrix[row-sub][col] == 'P')
                                    checkStop2=true;
                                else if (matrix[row-sub][col] != 'x'){
                                    matrix[row-sub][col] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop3){
                                if ((row-sub < 0) || (col+sub >= m) || matrix[row-sub][col+sub] == 'K' || matrix[row-sub][col+sub] == 'Q' || matrix[row-sub][col+sub] == 'P')
                                    checkStop3=true;
                                else if (matrix[row-sub][col+sub] != 'x'){
                                    matrix[row-sub][col+sub] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop4){
                                if ((col+sub >= m) || matrix[row][col+sub] == 'K' || matrix[row][col+sub] == 'Q' || matrix[row][col+sub] == 'P')
                                    checkStop4=true;
                                else if (matrix[row][col+sub] != 'x'){
                                    matrix[row][col+sub] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop5){
                                if ((row+sub >= n) || (col+sub >= m) || matrix[row+sub][col+sub] == 'K' || matrix[row+sub][col+sub] == 'Q' || matrix[row+sub][col+sub] == 'P')
                                    checkStop5=true;
                                else if (matrix[row+sub][col+sub] != 'x'){
                                    matrix[row+sub][col+sub] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop6){
                                if ((row+sub >= n) || matrix[row+sub][col] == 'K' || matrix[row+sub][col] == 'Q' || matrix[row+sub][col] == 'P')
                                    checkStop6=true;
                                else if (matrix[row+sub][col] != 'x'){
                                    matrix[row+sub][col] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop7){
                                if ((row+sub >= n) || (col-sub < 0) || matrix[row+sub][col-sub] == 'K' || matrix[row+sub][col-sub] == 'Q' || matrix[row+sub][col-sub] == 'P')
                                    checkStop7=true;
                                else if (matrix[row+sub][col-sub] != 'x'){
                                    matrix[row+sub][col-sub] = 'x';
                                    count--;
                                }
                            }

                            if (!checkStop8){
                                if ((col-sub < 0) || matrix[row][col-sub] == 'K' || matrix[row][col-sub] == 'Q' || matrix[row][col-sub] == 'P')
                                    checkStop8=true;
                                else if (matrix[row][col-sub] != 'x'){
                                    matrix[row][col-sub] = 'x';
                                    count--;
                                }
                            }

                            if (checkStop1 && checkStop2 && checkStop3 && checkStop4 && checkStop5 && checkStop6 && checkStop7 && checkStop8)
                                break;
                        }
                    }
                }
            }

            System.out.println("Board " + (++testCase) + " has " + count + " safe squares.");
            n = scanner.nextInt(); m = scanner.nextInt();
        }
    }
}
