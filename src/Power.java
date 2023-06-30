import java.util.InputMismatchException;
import java.util.Scanner;

public class Power {
     public static void main(String[] args) {
        try {
            int a = getInt("Введите первое число:");
            int b = getInt("Введите второе число:");

            System.out.println(calculatePower(a, b));
        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int calculatePower(int a, int b) throws InvalidInputException {
        if (a == 0) {
            throw new InvalidInputException ("Основание не может быть равно нулю.");
        }
        if (b < 0){
            throw new InvalidInputException ("Степень не может быть отрицательной.");
        }
        return (int) Math.pow(a, b);
    }

    public static int getInt(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: Введено некорректное число. Повторите ввод.");
                scanner.next();
            }
        }
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException (String message) {
            super(message);
        }
     }
}
