package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;
public class CalculateTwoDoubleNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input the first number: ", "Input the first number",
                    JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second number: ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        System.out.println("Sum: " + ( num1 + num2 ) + "\n");
        System.out.println("Difference: " + ( num1 - num2 ) + "\n");
        System.out.println("Product: " + ( num1 * num2 ) + "\n");
        if( num2 != 0)
            System.out.println("Quotient: " + ( num1 / num2 ) + "\n");
        else
            System.out.println("Can't caculate quotient!");
    }
}

