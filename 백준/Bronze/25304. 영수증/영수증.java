import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int xx = s.nextInt();
            int nn = s.nextInt();
            total += xx * nn;
        }
        if(total == x) {
            System.out.println("Yes");
        }
        if(total != x) {
            System.out.println("No");
        }

    }
}
