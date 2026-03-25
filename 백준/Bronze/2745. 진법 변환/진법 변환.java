import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String N = s.next();
        int B = s.nextInt();
        int result = 0;

        for (int i = 0; i < N.length(); i++) {
            int X = 1;
            for (int j = N.length() - 1; j > i; j--) {
                X *= B;
            }
            if(((int)N.charAt(i) - '0') >= 0 && ((int)N.charAt(i) - '0') < 10) {
                result += ((int) N.charAt(i) - '0') * X;
            }
            else {
                result += ((int) N.charAt(i) - 'A' + 10) * X;
            }
        }

        System.out.println(result);
    }
}