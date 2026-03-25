import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ANum = 0, BNum = 0;
        int[] ten = {100, 10, 1};

        String A = s.next(), B = s.next();

        String reversedA = new StringBuilder(A).reverse().toString();
        String reversedB = new StringBuilder(B).reverse().toString();


        for (int i = 0; i < 3; i++) {
            ANum += (reversedA.charAt(i) - '0') * ten[i];
        }
        for (int i = 0; i < 3; i++) {
            BNum += (reversedB.charAt(i) - '0') * ten[i];
        }

        System.out.println(Math.max(ANum, BNum));
    }
}
