import java.util.Scanner;
public class DisplayTheNumbersOfDaysOfAMonth {
    private static boolean check(int[] arr, int toCheckValue)
    {
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int arr1[] = {1, 3, 5, 7, 8, 10, 12};
        int arr2[] = {4, 6, 9, 11};
        int days;

        boolean condition = false;
        do {
            System.out.println("Enter the month: ");
            int month = input.nextInt();
            System.out.println("Enter the year: ");
            int year = input.nextInt();

            if (check(arr1, month))
                days = 31;
            else if (check(arr2, month))
                days = 30;
            else
                days = 28;

            switch (days){
                case 31:
                    System.out.println("There are 31 days.");
                    break;
                case 30: 
                    System.out.println("There are 30 days.");
                    break;
                case 28:
                    if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                        System.out.println("There are 29 days.");}
                    else 
                        {System.out.println("There are 28 days.");}
                    break;
                default:
                    System.out.println("It is an invalid month/year!");
                    condition = true;
                    break;
            }
        } while (condition);
    }
}
