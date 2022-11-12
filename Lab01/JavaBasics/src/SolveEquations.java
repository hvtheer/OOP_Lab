import javax.swing.JOptionPane;
public class SolveEquations {
    private void SolveFirstDegreeEquation() {
        String strNum1, strNum2;
        String result = null;

        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input a: ", "ax + b = 0",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input b: ", "ax + b = 0",
                    JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);

        if (a == 0) {
            if (b == 0)
                result = "The equations has no solution!";
            else
                result = "The equations has infinitely solutions!";
        } else
            result = "Solution of the equation: " + (- (b/a));

        JOptionPane.showMessageDialog(null,result,
                    "ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
    }

    private void SolveSystemOfFirstDegreeEquation() {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        String result = null;

        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input a11: ", "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,
                    "Please input a12: ", "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null,
                    "Please input b1: ", "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null,
                    "Please input a21: ", "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum5 = JOptionPane.showInputDialog(null,
                    "Please input a22: ", "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum6 = JOptionPane.showInputDialog(null,
                    "Please input b2: ", "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2",
                    JOptionPane.INFORMATION_MESSAGE);

        double a11 = Double.parseDouble(strNum1);
        double a12 = Double.parseDouble(strNum2);
        double b1 = Double.parseDouble(strNum3);
        double a21 = Double.parseDouble(strNum4);
        double a22 = Double.parseDouble(strNum5);
        double b2 = Double.parseDouble(strNum6);

        double D = (a11 * a22) - (a21 * a12);
        double Dx = (b1 * a22) - (b2 * a12);
        double Dy = (a11 * b2) - (a21 * b1);

        if (D == 0 && (Dx != 0 && Dy != 0))
            result = "The equation has no solution!";
        else if ( D == 0 && (Dx == 0 && Dy == 0))
            result = "The equation has infinitely many solutions!";
        else {
            double x1 = Dx/D, x2 = Dy/D;
            result = "Two solutions of the equation are: " + "x1 = " + x1  + " and x2 = " + x2;
        }

        JOptionPane.showMessageDialog(null,result,
                    "a11x1 + a12x2 = b1  a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
    }

    private void SolveSecondDegreeEquation() {
        String strNum1, strNum2, strNum3;
        String result = null;

        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input a: ", "ax^2 + bx + c = 0",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input b: ", "ax^2 + bx + c = 0",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null, 
                    "Please input c: ", "ax^2 + bx + c = 0",
                    JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        double c = Double.parseDouble(strNum3);

        if (a == 0) {
            if (b == 0) {
                result = "The equation has no solution!";
            } else {
                result = "The equation has a solution: " + "x = " + (-c / b);
            }
        }

        double delta = b*b - 4*a*c, x1 , x2;

        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            result = "Two solutions of the equation are: " + "x1 = " + x1 + " and x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            result = "The equation has a double solution: " + "x1 = x2 = " + x1;
        } else {
            result = "The equation has no solution!";
        }

        JOptionPane.showMessageDialog(null,result,
                    "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SolveEquations solve = new SolveEquations();
        solve.SolveFirstDegreeEquation();
        solve.SolveSystemOfFirstDegreeEquation();
        solve.SolveSecondDegreeEquation();
    }
}
