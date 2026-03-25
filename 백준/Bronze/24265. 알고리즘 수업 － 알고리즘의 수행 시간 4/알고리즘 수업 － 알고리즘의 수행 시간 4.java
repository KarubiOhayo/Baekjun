import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        long result = ((long) n * (n - 1) / 2);
        System.out.println(result);
        System.out.println(2);
    }
}