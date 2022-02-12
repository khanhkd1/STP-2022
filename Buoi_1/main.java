package STP_2022.Buoi_1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);
        while (true){
            x = scanner.nextInt();
            if (x==42)
                break;
            System.out.println(x);
        }
    }
}
