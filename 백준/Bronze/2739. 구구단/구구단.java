import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(a + " * " + i + " = " + a * i);
        }
    }
}
