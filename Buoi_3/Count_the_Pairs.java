package STP_2022.Buoi_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Count_the_Pairs {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt(), count = 0;
        int[] arr = new int[n];

        for (int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);

        for (int i=0; i<n; i++)
//            if (bSearch(arr, arr[i] + k))
            if (Arrays.binarySearch(arr, arr[i] + k) >= 0)
                count++;
        System.out.println(count);
    }
}
