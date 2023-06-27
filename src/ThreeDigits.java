import java.util.InputMismatchException;
import java.util.Scanner;

class NumberOutOfRangeException extends Exception{
    public NumberOutOfRangeException (String message){
        super(message);
    }
}

class NumberSumException  extends Exception{
    public NumberSumException (String message){
        super(message);
    }
}

public class ThreeDigits {

    public static void checkA(int a) throws NumberOutOfRangeException {
        if (a > 100) {
            throw new NumberOutOfRangeException("The first number is out of range.");
        }
    }

    public static void checkB(int b) throws NumberOutOfRangeException {
        if (b < 0) {
            throw new NumberOutOfRangeException("The second number is out of range.");
        }
    }

    public static void checkSum(int a, int b) throws NumberSumException {
        if (a + b < 10) {
            throw new NumberSumException("Sum of numbers is too small.");
        }
    }

    public static void checkC(int c) throws DivisionByZeroException {
        if (c == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
    }

    public static void main (String[]args) {

        Scanner scan = new Scanner(System.in);
        int a;
        int b;
        int c;
        while (true) {
            try {
                System.out.print("Enter number A: ");
                a = scan.nextInt();
                checkA(a);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bad input.");
                scan.nextLine();
            } catch (NumberOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter number B: ");
                b = scan.nextInt();
                checkB(b);
                checkSum(a, b);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bad input.");
                scan.nextLine();
            } catch (NumberOutOfRangeException e) {
                System.out.println(e.getMessage());
            } catch (NumberSumException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter number C: ");
                c = scan.nextInt();
                checkC(c);
                System.out.println("Check successful.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bad input.");
                scan.nextLine();
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


