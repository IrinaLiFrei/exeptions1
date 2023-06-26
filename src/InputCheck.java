import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class InputCheck {

    public static int division(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
    }


    public static void checkAge(String string){
        try {
            int age = Integer.parseInt(string);
            if (age < 0 || age > 130) {
                throw new IllegalArgumentException ("Impossible age.");
            } else {
                System.out.println("You are " + age + " years old.");
            }
        } catch (NumberFormatException e) {
            throw new ArithmeticException("Incorrect input.");
        }
    }

    public static void sumFromFile(String string){
        try (BufferedReader reader = new BufferedReader(new FileReader(string))) {
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Incorrect number value in file");
                }
            }
            System.out.printf("Sum of numbers in file '%s' is %d",  string, sum);
        } catch (
                IOException e) {
            System.out.println("File cannot be read.");
        }
    }

}

