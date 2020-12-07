import java.math.BigInteger;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int num = scan();
        BigInteger factorial = BigInteger.ONE;

        factorial = factorialSearch(num, factorial);

        int result = sumDigitsFactorial(factorial);

        System.out.println("Sum of factorial digits " + num + "!" + " =" + result);
    }

    private static int scan() {
        System.out.println("Enter a factorial to sum all its digits");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num > 0) {
            return num;
        } else {
            System.out.println("You entered a negative number");
            return scan();
        }
    }

    private static BigInteger factorialSearch(int num, BigInteger factorial) {
        // вычисляем факториал
        // calculate the factorial
        for (int i = 1; i <= num; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            if (factorial.remainder(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) { //// remove zeros
                factorial = factorial.divide(BigInteger.valueOf(10));
            }
        }
        return factorial;
    }

    private static int sumDigitsFactorial(BigInteger factorial) {
        // превращяем число в строку, затем в массив чаров, перебираем его суммируя все цифры
        // turn the number into a string, then into an array of chars, iterate over it summing all the numbers

        String temp = factorial.toString();
        char[] chars = temp.toCharArray();
        int result = 0;
        int number;
        for (char i : chars) {
            number = i - '0'; //char[0] ='9' =57 -0(48) = 9 etc. ("converting" char symbol to int)
            result += number;
        }
        return result;

    }
}
