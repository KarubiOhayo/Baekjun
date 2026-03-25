import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] realCheck = {1, 1, 2, 2, 2, 8};
        int[] oldCheck = new int[6];

        for (int i = 0; i < 6; i++) {
            oldCheck[i] = s.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(realCheck[i] - oldCheck[i] + " ");
        }
    }
}
