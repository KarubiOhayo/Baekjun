import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String S = s.next();
        int i = s.nextInt();

        System.out.println(S.charAt(i - 1));
    }
}
