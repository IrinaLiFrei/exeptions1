
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a dividend: ");
        int inputResult1 = scanner.nextInt();
        System.out.println("Enter a divisor: ");
        int inputResult2 = scanner.nextInt();
        System.out.print(inputResult1 + " : " + inputResult2 + " = ");
        System.out.println(InputCheck.division(inputResult1, inputResult2));
        scanner.nextLine();


        System.out.println("Enter your age: ");
        String string = scanner.nextLine();
        InputCheck.checkAge(string);
        System.out.println();


        InputCheck.sumFromFile("text.txt");
        System.out.println();
    }
}