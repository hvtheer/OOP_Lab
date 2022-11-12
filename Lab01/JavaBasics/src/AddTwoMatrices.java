import java.util.Scanner;
public class AddTwoMatrices {
    public static void main(String[] args) {
        int m, n;
        Scanner input = new Scanner(System.in);

        System.out.println("Input number of rows of matrix");
        m = input.nextInt();
        System.out.println("Input number of rows of matrix");
        n = input.nextInt();

        int arr1[][] = new int[m][n];
        int arr2[][] = new int[m][n];
        int sum[][] = new int[m][n];

        System.out.println("Input elements of 1st matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                arr1[i][j] = input.nextInt();
            }
        }

        System.out.println("Input elements of 2nd matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                arr2[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println("Sum of the matrices: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(sum[i][j]+"\t");
            System.out.println();
        }
    }
}
