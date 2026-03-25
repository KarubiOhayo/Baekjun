import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int A = s.nextInt(),
            B = s.nextInt(),
            V = s.nextInt();

        int days = (V - B - 1) / (A - B) + 1;
        System.out.println(days);
    }
}