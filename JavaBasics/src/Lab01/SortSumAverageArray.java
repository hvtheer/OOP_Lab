package Lab01;
import java.util.Scanner;
import java.util.Arrays;

public class SortSumAverageArray {
    public static void inputArr(int[] arr,Scanner input) {
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = input.nextInt();
        }
    }

    public static void sortAsc(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >  arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements of the array: ");
        int n = input.nextInt();
        
        int[] arr = new int[n];
        inputArr(arr, input);
        sortAsc(arr);
        System.out.println("Numbers are sorted in ascending order: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sum: " + sumArr(arr));
        System.out.println("Average: " + ((double)sumArr(arr) / arr.length));
    }
}