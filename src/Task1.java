import java.util.Scanner;
// from wikipedia the number of correct parenthesis sequences is equal to the Catalan number.
//to find the Catalan number, we will create 2 methods.
public class Task1 {
    public static void main(String[] args) {

        int parentheses = enterNum();//scanner
        findParentheses(parentheses);// Catalan number
        System.out.println(findParentheses(parentheses));
    }

    private static int enterNum() {
        System.out.println("enter non-negative number ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num < 0) {
            System.out.println("Wrong number");
            return enterNum();
        } else return num;
    }

    public static int findParentheses(int enterNum) {
        int a = fact(2 * enterNum);
        int b = fact(enterNum);
        int c = fact(enterNum + 1);
        return a / (b * c);
    }


    private static int fact(int i) { //factorial finder
        if (i == 1)
            return 1;
        return i * fact(i - 1);
    }
}

