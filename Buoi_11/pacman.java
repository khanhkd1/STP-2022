package STP_2022.Buoi_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class pacman {
    static int n, m, x_pacman, y_pacman, x_ghost, y_ghost, dir_pacman, dir_ghost;
    static long gold_pacman, gold_ghost;
    static int[][] matrix = new int[100][100];
    static char[] pacman_dirs = new char[300], ghost_dirs = new char[300];
    static int[] x_next = {0, -1, 0, 1};
    static int[] y_next = {-1, 0, 1, 0};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);

        String temp;
        int testCases = scanner.nextInt();
        for (int testCase=1; testCase<=testCases; testCase++){
            // input
            n = scanner.nextInt(); m = scanner.nextInt();
            for (int i=0; i<n; i++)
                for (int j=0; j<n; j++)
                    matrix[i][j] = scanner.nextInt();
            temp = scanner.next();
            for (int i=0; i<m; i++)
                pacman_dirs[i] = temp.charAt(i);
            temp = scanner.next();
            for (int i=0; i<m; i++)
                ghost_dirs[i] = temp.charAt(i);
            // end input

            // reset parameters
            x_pacman=0; y_pacman=0; x_ghost=n-1; y_ghost=n-1; gold_pacman=0; gold_ghost=0; dir_pacman=3; dir_ghost=1;

            for (int i=0; i<m; i++){
                if (pacman_dirs[i] == 'L')
                    dir_pacman = (dir_pacman + 3) % 4;
                else if (pacman_dirs[i] == 'R')
                    dir_pacman = (dir_pacman + 1) % 4;

                x_pacman += x_next[dir_pacman];
                y_pacman += y_next[dir_pacman];

                if (ghost_dirs[i] == 'L')
                    dir_ghost = (dir_ghost + 3) % 4;
                else if (ghost_dirs[i] == 'R')
                    dir_ghost = (dir_ghost + 1) % 4;

                x_ghost += x_next[dir_ghost];
                y_ghost += y_next[dir_ghost];

                if (x_pacman == x_ghost && y_pacman == y_ghost)
                    break;
                else {
                    gold_pacman += matrix[x_pacman][y_pacman];
                    matrix[x_pacman][y_pacman] = 0;
                    gold_ghost += matrix[x_ghost][y_ghost];
                    matrix[x_ghost][y_ghost] = 0;
                }
            }
            System.out.println("#" + testCase + " " + gold_pacman + " " + gold_ghost);
        }
    }
}
