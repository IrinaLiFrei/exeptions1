import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTransaction {
    public static void main(String[] args) {
        int currentAccountBalance = 10000;
        int targetAccountBalance = 0;

        while (true) {
            try {
                int a = getInt("Введите сумму перевода: ");
                currentAccountBalance = transferFunds(a, currentAccountBalance);
                System.out.println("Перевод выполнен успешно." + "\n" + "Остаток на счете отправителя: " + currentAccountBalance);
                targetAccountBalance += a;
                System.out.println("Остаток на счете получателя: " + targetAccountBalance);
                if (currentAccountBalance == 0) {
                    System.out.println();
                    System.out.println("Ваш баланс равен нулю. Дальнейшие переводы невозможны.");
                    return;
                }
            } catch (InvalidAmountException | InsufficientFundsException ex) {
                System.out.println(ex.getMessage() + " Ваш баланс: " + currentAccountBalance);
            }
        }
}

    public static int transferFunds(int a, int b) throws InvalidAmountException, InsufficientFundsException {
        if (a == 0 || a < 0) {
            throw new InvalidAmountException("Некорректная сумма перевода.");
        }
        if (b - a < 0){
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


