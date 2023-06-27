import java.util.InputMismatchException;
import java.util.Scanner;

public class OneDigit {

    public static void checkNumber(int value) throws InvalidNumberException {
        if (value <= 0) {
            throw new InvalidNumberException("Invalid number.");
        }
        System.out.println("Number is valid.");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter a positive number: ");
                int value = scan.nextInt();
                checkNumber(value);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bad input.");
                scan.nextLine();
            } catch (InvalidNumberException e) {
                System.out.println("Invalid number.");
            }
        }
    }
}

class InvalidNumberException extends Exception{

    public InvalidNumberException (String message){
        super(message);
    }
}