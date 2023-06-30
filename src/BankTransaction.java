import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTransaction {
    public static void main(String[] args) {
        int balance = 10000;
        try {
            int a = getInt("Введите сумму перевода: ");
            System.out.println("Перевод выполнен успешно. Остаток на счете: " + transfer(a, balance));
        } catch (InvalidAmountException | InsufficientFundsException ex) {
            System.out.println(ex.getMessage() + " Ваш баланс: " + balance);
        }
}

    public static int transfer(int a, int b) throws InvalidAmountException, InsufficientFundsException {
        if (a == 0 || a < 0) {
            throw new InvalidAmountException("Некорректная сумма перевода.");
        }
        if (b - a <= 0){
            throw new InsufficientFundsException("Недостаточно средств для перевода.");
        }
        return b - a;
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

    static class InvalidAmountException extends Exception {
        public InvalidAmountException (String message) {
            super(message);
        }
    }

    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException (String message) {
            super(message);
        }
    }
}


