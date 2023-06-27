import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoDigits {




    public static void checkDivisor(int number) throws DivisionByZeroException {
        if (number == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed");
        }
    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a;
        int b;
        int c;
        while (true) {
            try {
                System.out.print("Enter number A: ");
                a = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bad input.");
                scan.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Enter number B: ");
                b = scan.nextInt();
                checkDivisor(b);
                c = a / b;
                System.out.printf("%d : %d = %d", a, b, c);
                    break;
                } catch (DivisionByZeroException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e){
                System.out.println("Bad input.");
                scan.nextLine();
            }
        }
    }

}





class DivisionByZeroException extends Exception{

    public DivisionByZeroException (String message){
        super(message);
    }
}

