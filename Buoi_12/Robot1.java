package STP_2022.Buoi_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Robot1 {
    static int checkDirection(int xPre, int yPre, int x, int y){
        if (x == xPre){
            if (y == yPre+1)
                return 1;
            else return 3;
        } else if (x == xPre + 1)
            return 2;
        else return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase=1; testCase<=testCases; testCase++){
            int n = scanner.nextInt();
            int rightCount = 0, direction=0, nextDirection, xPre=0, yPre=0, x=0, y=0;

            for (int i=0; i<n; i++){
                xPre = x; yPre = y;
                x = scanner.nextInt(); y = scanner.nextInt();

                if (i==1){
                    direction = checkDirection(xPre, yPre, x, y);
                }
                else if (i>1) {
                    nextDirection = checkDirection(xPre, yPre, x, y);
                    if ((direction + 1) % 4 == nextDirection)
                        rightCount++;
                    direction = nextDirection;
                }
            }
            System.out.println("#" + testCase + " " + rightCount);
        }
    }
}
