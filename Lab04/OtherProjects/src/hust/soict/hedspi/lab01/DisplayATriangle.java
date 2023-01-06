package hust.soict.hedspi.lab01;

import java.util.Scanner;
public class DisplayATriangle{
    public static void main(String args[]){
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Input n:");
            int n = keyboard.nextInt();

            int i = 1, j = 0, k = 0;
            
            while (i <= n) {
                while (k <= n - i - 1) {
                    System.out.print(" ");
                    k++;
                }
                k = 0;
                while (j < 2 * i - 1) {
                    System.out.print("*");
                    j++;
                }
                j = 0;
                i++;
                System.out.print("\n");
            }
        }
    }
}